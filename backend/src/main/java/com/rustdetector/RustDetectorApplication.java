package com.rustdetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RustDetectorApplication {
	public static void main(String[] args) {
		SpringApplication.run(RustDetectorApplication.class, args);
	}
}
