package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Customer;
import Santander.Loan.reposiroty.CustomerRepository;
import Santander.Loan.reposiroty.UserRepository;
import Santander.Loan.security.RoleEnum;
import Santander.Loan.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createCustomer(Customer customer) {
        if (userRepository.existsByUsername(customer.getUsername())) {
            throw new BusinessException("Este Username já está sendo utilizado.");
        }
        if (userRepository.existsByEmail(customer.getEmail())) {
            throw new BusinessException("Este e-mail já foi cadastrado.");
        }
        if (userRepository.existsByCpf(customer.getCpf())) {
            throw new BusinessException("Este CPF já foi cadastrado.");
        }

        // Verifica se a senha contém apenas dígitos numéricos
        if (!isNumericPassword(customer.getPassword())) {
            throw new BusinessException("A senha deve conter entre 6 e 10 dígitos numéricos.");
        }

        // Criptografa a senha antes de salvar
        String encryptedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);

        // Define as roles do cliente
        List<RoleEnum> roles = new ArrayList<>();
        roles.add(RoleEnum.USER);
        customer.setRoles(roles);

        // Salva o cliente no banco de dados
        customerRepository.save(customer);
    }

    private boolean isNumericPassword(String password) {
        // Utiliza uma expressão regular para verificar se a senha contém apenas dígitos numéricos
        return Pattern.matches("^\\d{6,10}$", password);
    }

    public void deleteCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new BusinessException("Cliente com ID '" + customerId + "' não encontrado.");
        }
        customerRepository.deleteById(customerId);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        if (customerList.isEmpty()){
            throw new BusinessException("A lista de customers está vazia.");
        }
        return customerList;
    }

    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException("Cliente com o ID '" + customerId +"' não foi encontrado."));
    }

    @Override
    public void updateCustomer(Customer updatedCustomer) {
            // Verifica se o cliente existe no banco de dados
            if (!isNumericPassword(updatedCustomer.getPassword())) {
                throw new BusinessException("A senha deve conter entre 6 e 10 dígitos numéricos.");
            }
        try {
            Customer existingCustomer = customerRepository.findById(updatedCustomer.getId())
                    .orElseThrow(() -> new BusinessException("Cliente não encontrado."));

            // Atualiza os dados do cliente com base nos valores fornecidos
            existingCustomer.setUsername(updatedCustomer.getUsername());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setCpf(updatedCustomer.getCpf());
            existingCustomer.setFullName(updatedCustomer.getFullName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setTelephone(updatedCustomer.getTelephone());
            existingCustomer.setPassword(updatedCustomer.getPassword());

            // Salva as alterações no banco de dados
            customerRepository.save(existingCustomer);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar cliente. Contém campo inválido. Mensagem do erro: " + e.getMessage());
        }
    }
}
