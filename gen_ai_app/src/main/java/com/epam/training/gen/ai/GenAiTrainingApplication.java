package com.epam.training.gen.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/application.yaml")
public class GenAiTrainingApplication {

	public static void main(String[] args) {

		SpringApplication.run(GenAiTrainingApplication.class, args);
	}

}
