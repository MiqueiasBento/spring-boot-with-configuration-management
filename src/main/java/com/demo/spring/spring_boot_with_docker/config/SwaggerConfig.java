package com.demo.spring.spring_boot_with_docker.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Minha API")
                        .version("1.0.0")
                        .description("API para aprendizado de Spring Boot com Swagger"));
    }
}
