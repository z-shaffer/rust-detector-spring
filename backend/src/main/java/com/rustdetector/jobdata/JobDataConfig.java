package com.rustdetector.jobdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JobDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(JobDataRepository repository) {
        return args -> {
        };
    }
}
