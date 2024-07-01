package com.alibou.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class FirstController {

	@GetMapping("/hello")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String sayHello() {
		return "Hello from my first controller!";
	}

	@PostMapping("/post")
	public String post(
		@RequestBody String message
	) {
		return "Request accepted and message is " + message;
	}

	@PostMapping("/post-order")
	public String post(
		@RequestBody Order order
	) {
		return "Request accepted and order is " + order.toString();
	}

}
