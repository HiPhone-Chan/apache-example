package com.chf.example.apache.zookeeper;

public interface DataListener {

	void exists(byte data[]);

	void closing(int reasonCode);
}
