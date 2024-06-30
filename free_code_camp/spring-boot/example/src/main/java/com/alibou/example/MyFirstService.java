package com.alibou.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

	private MyFirstClass myFirstClass;

	@Autowired
	public void setMyFirstClass(@Qualifier("myThirdBean") MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}

	public String tellStory() {
		return "Bean saying: " + myFirstClass.sayHello();
	}
}
