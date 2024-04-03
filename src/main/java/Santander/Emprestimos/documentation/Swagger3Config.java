package Santander.Emprestimos.documentation;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Swagger3Config {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("loan-application")
                .pathsToMatch("/**", "/api/credits/**")
                .build();
    }
}
