package com.example.demo.model;

import java.util.UUID;

public class Lock {
	
	private String key;
	
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Lock(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Lock(String key) {
		super();
		this.key = key;
		value=UUID.randomUUID().toString();
	}
	
	
}
