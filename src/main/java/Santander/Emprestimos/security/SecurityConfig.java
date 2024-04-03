//package Santander.Emprestimos.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static Santander.Emprestimos.security.RoleEnum.ADMIN;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    public SecurityFilterChain web(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//
////                                .requestMatchers(HttpMethod.POST, "/customers/**").authenticated() // Allow POST to /customers/post
////                                .requestMatchers(HttpMethod.POST, "/customers/post").authenticated()  // Allow POST to /customers/post
////                                .anyRequest().authenticated() //permite o swagger sem problemas
//
//                                .requestMatchers(HttpMethod.POST, "/customers/post").permitAll()  // Allow POST to /customers/post
//                                .requestMatchers(HttpMethod.POST, "/customers/**").permitAll()  // Allow POST to /customers/post
//                                .requestMatchers("/resource/**").permitAll()
//                                .requestMatchers("/swagger-ui/index.html/**", "/swagger-ui/index.html", "/swagger-ui/index.html/", "/v3/api-docs", "/swagger-ui.html", "/swagger-resources/**", "/webjars/**").permitAll()
//                                .requestMatchers("/h2-console/**").permitAll()
//                                .requestMatchers("/customers/**").permitAll()
//                                .requestMatchers("/customers/post").permitAll()
//                                .anyRequest().authenticated() //permite o swagger sem problemas
//
//
////                        .requestMatchers("/db/**")
////                        .access(new WebExpressionAuthorizationManager("hasRole('ADMIN') and hasRole('DBA')"))
////                                .requestMatchers(HttpMethod.POST, "/customers/post").hasRole("ADMIN")
////                                .requestMatchers("/customers/post").hasAuthority(String.valueOf(ADMIN))
//
//
//                )
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**", "/swagger-ui/index.html/**", "/v3/api-docs/**"))
//                .headers().frameOptions().disable();
//
//
//
//        http.httpBasic(); //permite o swagger sem problemas
//
//        return http.build();
//    }
//
////        @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//}
//
