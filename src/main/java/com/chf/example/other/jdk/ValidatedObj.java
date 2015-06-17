package com.chf.example.other.jdk;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidatedObj {

	// @NotNull
	@NotEmpty
	private String str;

	// @Min(2)
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
		obj.setStr("as");
		System.out.println(DataValidationUtils.check(obj));
	}
}
