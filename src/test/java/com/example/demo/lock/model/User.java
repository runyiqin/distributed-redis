package com.example.demo.lock.model;

public class User {
	
	private String username;
	
	private long money;
	
	public User() {
		super();
	}

	public User(String username, long money) {
		super();
		this.username = username;
		this.money = money;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}
	
	
}
