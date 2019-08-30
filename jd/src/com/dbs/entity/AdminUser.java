package com.dbs.entity;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class AdminUser{
	private String username;
	private String password;
	private String phone;
	private String email;
	private String sex;
	private String address;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getSex() {
		return sex;
	}
	public String getAddress() {
		return address;
	}
	public AdminUser(String username, String password, String phone, String email, String sex, String address) {
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.sex = sex;
		this.address = address;
	}
}
