package com.alibou.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

	private final MyFirstClass myFirstClass;

	@Value("${my.custom.property}")
	private String customProperty; 
	@Value("${my.custom.property.int}")
	private Integer customPropertyInt;
	public void setCustomProperty(String customProperty) {
		this.customProperty = customProperty;
	}

	public Integer getCustomPropertyInt() {
		return this.customPropertyInt;
	}

	public MyFirstClass getMyFirstClass() {
		return this.myFirstClass;
	}

	public String getCustomProperty() {
		return this.customProperty;
	}

	public MyFirstService(@Qualifier("bean1") MyFirstClass myFirstClass) {
		this.myFirstClass = myFirstClass;
	}

	public String tellStory() {
		return "Bean saying: " + myFirstClass.sayHello();
	}
}
