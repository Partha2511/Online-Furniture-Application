package com.cg.OFS.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int uid;
	//@NotBlank(message = "Username is mandatory")
	@Column(name="user_name")
	private String username;
	//@NotBlank(message = "Password is mandatory")
	@Column(name="password")
	private String password;
	//@NotBlank(message = "Role is mandatory")
	@Column(name="role")
	private String role;
	
//	@OneToOne
//	private Customer customer;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String username, String password, String role) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
