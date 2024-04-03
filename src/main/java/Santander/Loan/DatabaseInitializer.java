//package Santander.Emprestimos;
//
//import Santander.Emprestimos.reposiroty.UserRepository;
//import Santander.Emprestimos.security.RoleEnum;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import Santander.Emprestimos.model.Users;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class DatabaseInitializer implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//
//    public DatabaseInitializer(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Crie um novo usuário
//        Users user = new Users();
//        user.setUsername("amandinha");
//        user.setPassword("senha123");
//        user.setEmail("123@example.com");
//        user.setCpf("12345678900");
//        user.setFullName("Amanda G");
//        Set<RoleEnum> roles = new HashSet<>();
//        roles.add(RoleEnum.USER);
//        roles.add(RoleEnum.ADMIN);
//        roles.add(RoleEnum.CUSTOMER_SERVICE_REPRESENTATIVE);
//        user.setRoles(roles);
//        user.setAddress("123 Main Street");
//        user.setTelephone("555-1234");
//
//        // Salve o usuário no banco de dados
//        userRepository.save(user);
//    }
//}
