package com.ncs.green.domain;

public class UserDTO {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	private String loginTime;

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", loginTime=" + loginTime + "]";
	}
}
