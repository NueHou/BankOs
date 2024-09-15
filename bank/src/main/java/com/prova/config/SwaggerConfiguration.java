package com.prova.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("bankos")
                .pathsToMatch("/**")
                .packagesToScan("com.prova.resources")
                .build();
    }

    @Bean
    public io.swagger.v3.oas.models.OpenAPI custoOpenAPI(){
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info().title("bankOs")
                                .description("BankOs APIs")
                                .version("1.0")
                                .contact(new Contact()
                                    .name("Bank")
                                    .url("http://www.bank.com.br")
                                    .email("bank@email.com")));
    }
}
