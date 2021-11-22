package com.stackoverlow.autowire.validation.validation;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	public boolean foo(String valueToValidate) {
		return "hello".equalsIgnoreCase(valueToValidate);
	}
}
