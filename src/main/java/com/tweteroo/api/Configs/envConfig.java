package com.tweteroo.api.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class envConfig {
    @Bean
    public Dotenv dotenv() {
        Dotenv dotenv = Dotenv.load();

        return dotenv;

    }
}
