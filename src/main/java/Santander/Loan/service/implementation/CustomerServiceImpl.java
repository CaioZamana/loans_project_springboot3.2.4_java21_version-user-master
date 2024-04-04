package Santander.Loan.service.implementation;

import Santander.Loan.exception.serviceexception.BusinessException;
import Santander.Loan.model.Customer;
import Santander.Loan.reposiroty.CustomerRepository;
import Santander.Loan.security.RoleEnum;
import Santander.Loan.service.interfaces.ICustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
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

        List<RoleEnum> roles = new ArrayList<>();
        roles.add(RoleEnum.USER);

        customer.setRoles(roles);

        customerRepository.save(customer);
    }




    public void deleteCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new BusinessException("Cliente com ID " + customerId + " não encontrado.");
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

//    public void updateCustomer(Customer updatedCustomer) {
//        try {
//            // Verifica se o cliente existe no banco de dados
//            if (!customerRepository.existsById(updatedCustomer.getId())) {
//                throw new BusinessException("Cliente não encontrado");
//            }
//
//            // Obtém o cliente existente do banco de dados
//            Customer existingCustomer = customerRepository.getById(updatedCustomer.getId());
//
//            // Verifica se a senha do cliente atualizado atende aos critérios de validação
//            existingCustomer.setPassword(updatedCustomer.getPassword());
//
//            // Atualiza os outros dados do cliente existente com os dados do cliente atualizado
//            existingCustomer.setUsername(updatedCustomer.getUsername());
//            existingCustomer.setEmail(updatedCustomer.getEmail());
//            existingCustomer.setCpf(updatedCustomer.getCpf());
//            existingCustomer.setFullName(updatedCustomer.getFullName());
//            existingCustomer.setAddress(updatedCustomer.getAddress());
//            existingCustomer.setTelephone(updatedCustomer.getTelephone());
//
//            // Salva as alterações no banco de dados
//            customerRepository.save(existingCustomer);
//        } catch (Exception e) {
//            throw new BusinessException("Erro ao atualizar cliente. Mensagem do erro: " + e.getMessage());
//        }
//    }



    @Override
    public void updateCustomer(Customer updatedCustomer) {
        try {
            // Verifica se o cliente existe no banco de dados
            Customer existingCustomer = customerRepository.findById(updatedCustomer.getId())
                    .orElseThrow(() -> new BusinessException("Cliente não encontrado"));

            // Atualiza os dados do cliente com base nos valores fornecidos
            existingCustomer.setUsername(updatedCustomer.getUsername());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setCpf(updatedCustomer.getCpf());
            existingCustomer.setFullName(updatedCustomer.getFullName());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setTelephone(updatedCustomer.getTelephone());

            // Salva as alterações no banco de dados
            customerRepository.save(existingCustomer);
        } catch (Exception e) {
            throw new BusinessException("Erro ao atualizar cliente. Mensagem do erro: " + e.getMessage());
        }
    }
}
