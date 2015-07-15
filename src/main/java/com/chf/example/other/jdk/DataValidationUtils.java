package com.chf.example.other.jdk;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class DataValidationUtils {
	private static final ValidatorFactory factory = Validation
			.buildDefaultValidatorFactory();

	/**
	 * 
	 * @param obj
	 * @return true if all check passes
	 */
	public static boolean check(Object obj) {
		Validator validator = factory.getValidator();

		Set<?> set = validator.validate(obj);
		return set.size() == 0;
	}

	public static String check2(Object obj) {
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Object>> set = validator.validate(obj);
		for (ConstraintViolation<Object> cobj : set) {
			return cobj.getMessage();
		}
		return "ok";
	}
}
