package com.chf.example.domain;

import java.io.Serializable;

public class D implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public D(String str) {
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
		return "D [str=" + str + "]";
	}

}
