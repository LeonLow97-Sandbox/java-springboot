package com.alibou.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {
	@Bean("bean1")
	public MyFirstClass myFirstClass() {
		return new MyFirstClass("My First Bean");
	}

	@Bean
	public MyFirstClass mySecondBean() {
		return new MyFirstClass("My Second Bean");
	}

	@Bean
	// @Primary
	public MyFirstClass myThirdBean() {
		return new MyFirstClass("My Third Bean");
	}
}
