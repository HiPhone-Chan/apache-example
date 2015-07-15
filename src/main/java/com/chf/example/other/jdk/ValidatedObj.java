package com.chf.example.other.jdk;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidatedObj {

	// @NotNull
	@NotEmpty(message = "401")
	private String str;

	@Min(value = 2, message = "402")
	@Max(value = 5, message = "403")
	private int num;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public static void main(String[] args) {
		ValidatedObj obj = new ValidatedObj();
		// obj.setStr("");
//		obj.setNum(6);
		System.out.println(DataValidationUtils.check2(obj));
	}
}
