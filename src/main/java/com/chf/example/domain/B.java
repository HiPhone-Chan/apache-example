package com.chf.example.domain;

public class B {

	private String str;

	private String strB;

	private int a;

	private C c;

	private C d;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getStrB() {
		return strB;
	}

	public void setStrB(String strB) {
		this.strB = strB;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public C getD() {
		return d;
	}

	public void setD(C d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "B [str=" + str + ", strB=" + strB + ", a=" + a + ", c=" + c
				+ ", d=" + d + "]";
	}

}
