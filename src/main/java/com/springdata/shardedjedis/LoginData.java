package com.springdata.shardedjedis;

import java.io.Serializable;

public class LoginData implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private String code;
	private String name;
	private String ip;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public void print(){
		System.out.println("123");
	}

}
