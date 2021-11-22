package com.stackoverlow.autowire.validation.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Scope("request")
public class MyValidator implements ConstraintValidator<MyValid, String> {

	private MyService myService;

	@Autowired
	public MyValidator(MyService aService) {
		myService = aService;
	}

	@Override
	public void initialize(MyValid myValid) {
		// we can also do things here
	}

	/**
	 * @throws: NullPointerException, when <code>myService == null</code>.
	 */
	@Override
	public boolean isValid(String valueToValid, ConstraintValidatorContext context) {
		log.info("custom validation");
		boolean valid = myService.foo(valueToValid);
		return valid;
	}
}