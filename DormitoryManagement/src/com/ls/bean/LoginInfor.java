package com.ls.bean;

public class LoginInfor {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginInfor(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	private String name;
	@Override
	public String toString() {
		return "LoginInfor [name=" + name + ", password=" + password + "]";
	}
	private String password;

}
