package com.example.extension_block_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExtensionBlockSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExtensionBlockSystemApplication.class, args);
    }

}
