package com.bitsplease.qrshop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * @author Chrisostomos Bakouras.
 */
@Import({
        com.bitsplease.qrshop.domain.DomainConfig.class,
        com.bitsplease.qrshop.security.SecurityConfig.class,
        com.bitsplease.qrshop.service.ServiceConfig.class,
        com.bitsplease.qrshop.mapper.MapperConfig.class
})
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
