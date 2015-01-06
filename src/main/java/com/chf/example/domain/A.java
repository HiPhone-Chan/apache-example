package com.chf.example.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class A implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3741998641726625937L;

	private String str;

	private String strA;

	private int a;

	private D d;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getStrA() {
		return strA;
	}

	public void setStrA(String strA) {
		this.strA = strA;
	}

	public D getD() {
		return d;
	}

	public void setD(D d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return String
				.format("A [str=%s, strA=%s, a=%s, d=%s]", str, strA, a, d);
	}

}
