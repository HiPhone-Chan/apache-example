package com.chf.example.domain;

public class SimplePojo {
	private String str;

	private int num = 1;

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

	@Override
	public String toString() {
		return String.format("SimplePojo [str=%s, num=%s]", str, num);
	}
}
