package Santander.Emprestimos.service.implementation;

import Santander.Emprestimos.exception.BusinessException;
import Santander.Emprestimos.model.Customer;
import Santander.Emprestimos.reposiroty.CustomerRepository;
import Santander.Emprestimos.security.RoleEnum;
import Santander.Emprestimos.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        if (customerRepository.existsByUsername(customer.getUsername())) {
            throw new BusinessException("Este Username já está sendo utilizado.");
        }
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new BusinessException("Este e-mail já foi cadastrado.");
        }
        if (customerRepository.existsByCpf(customer.getCpf())) {
            throw new BusinessException("Este CPF já foi cadastrado.");
        }

        Set<RoleEnum> roles = new HashSet<>();
        roles.add(RoleEnum.USER);

        customer.setRoles(roles);

        customerRepository.save(customer);
    }




    public void deleteCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new BusinessException("Cliente com ID " + customerId + " não encontrado");
        }
        customerRepository.deleteById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new BusinessException("Cliente com o ID '" + customerId +"' não foi encontrado."));
    }

    public void updateCustomer(Customer updatedCustomer) {
        try {
            // Verifica se o cliente existe no banco de dados
            if (!customerRepository.existsById(updatedCustomer.getId())) {
                throw new BusinessException("Cliente não encontrado");
            }


            // Obtém o cliente existente do banco de dados
            Customer existingCustomer = customerRepository.getById(updatedCustomer.getId());

            // Atualiza os dados do cliente existente com os dados do cliente atualizado
            existingCustomer.setUsername(updatedCustomer.getUsername());
            existingCustomer.setPassword(updatedCustomer.getPassword());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setCpf(updatedCustomer.getCpf());
            existingCustomer.setFullName(updatedCustomer.getFullName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setTelephone(updatedCustomer.getTelephone());
            // Atualize outros campos conforme necessário...

            // Salva as alterações no banco de dados
            customerRepository.save(existingCustomer);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar cliente, username, cpf ou e-mail já estão sendo utilizados. Mensagem do erro: " + e.getMessage());
        }
    }

}
