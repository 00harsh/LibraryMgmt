package com.libraryManagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig(){
        return new OpenAPI().info(
            new Info().title("Library Management System")
                    .description("By Harsh Gupta")
        )
            .servers(List.of(new Server().url("http://localhost:8080/swagger-ui/index.html").description("local"),
                    new Server().url("http://localhost:8082/swagger-ui/index.html").description("live")))
                .tags(List.of(
                        new Tag().name("User Controller")
                ));
    }

}
