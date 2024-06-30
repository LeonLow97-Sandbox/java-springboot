package com.alibou.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		// ctx is context of our application
		var ctx = SpringApplication.run(ExampleApplication.class, args);

		MyFirstClass myFirstClass = ctx.getBean("myBean", MyFirstClass.class);
		System.out.println(myFirstClass.sayHello());
	}
}
