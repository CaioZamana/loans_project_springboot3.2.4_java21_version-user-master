//package Santander.Emprestimos.service.implementation;
//
//
//import Santander.Emprestimos.exception.BusinessException;
//import Santander.Emprestimos.model.Customer;
//import Santander.Emprestimos.reposiroty.CustomerRepository;
//import Santander.Emprestimos.security.RoleEnum;
//import Santander.Emprestimos.service.interfaces.ICustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CustomerService implements ICustomerService {
//
//    private final CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public Customer getCustomerById(Long customerId) {
//        return customerRepository.findById(customerId)
//                .orElseThrow(() -> new BusinessException("Customer não encontrado com o ID: " + customerId));
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    @Override
//    public void createCustomer(Customer customer) {
//        // Verificar se já existe um cliente com o mesmo username ou email
//        if (customerRepository.existsByUsername(customer.getUsername())) {
//            throw new BusinessException("Já existe um cliente com o mesmo username.");
//        }
//        if (customerRepository.existsByEmail(customer.getEmail())) {
//            throw new BusinessException("Este e-mail já foi registrado.");
//        }
//
//        // Configurar o papel do cliente
//        customer.setRole(RoleEnum.CUSTOMER);
//
//        // Salvar o cliente
//        customerRepository.save(customer);
//    }
//
//
//    @Override
//    public void updateCustomer(Customer customer) {
//        try {
//            customerRepository.save(customer);
//        } catch (Exception e){
//            throw new BusinessException("Erro ao atualizar cliente: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteCustomer(Long customerId) {
//        if (!customerRepository.existsById(customerId)) {
//            throw new BusinessException("Cliente com ID " + customerId + " não encontrado");
//        }
//        customerRepository.deleteById(customerId);
//    }
//
//    @Override
//    public Customer getCustomerByUsername(String username){
//        Customer customer = customerRepository.findByUsername(username);
//        if (customer == null) {
//            throw new BusinessException("Cliente com o nome de usuário " + username + " não encontrado");
//        }
//        return customer;
//    }
//
//    @Override
//    public Customer getCustomerByEmail(String email){
//        Customer customer = customerRepository.findByEmail(email);
//        if (customer == null) {
//            throw new BusinessException("Cliente com o endereço de e-mail " + email + " não encontrado");
//        }
//        return customer;
//    }
//}
