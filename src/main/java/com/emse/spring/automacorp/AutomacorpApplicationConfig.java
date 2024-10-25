package com.emse.spring.automacorp;

import com.emse.spring.automacorp.hello.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AutomacorpApplicationConfig {
    @Bean
    public CommandLineRunner greetingCommandLine(@Qualifier("consoleGreetingService") GreetingService greetingService) {
        return args -> {
            greetingService.greet("Spring");
        };
    }
}