package com.chf.example.domain;

public class C {

	public C(String str) {
		this.str = str;
	}

	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "C [str=" + str + "]";
	}

}
