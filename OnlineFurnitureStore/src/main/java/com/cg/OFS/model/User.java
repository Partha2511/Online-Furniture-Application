package com.cg.OFS.model;

import javax.persistence.*;

@Entity
@Table(name="User_tbl")
public class User {
	
	@Id
	private int uid;
	@Column(name="Username", length=30)
	private String username;
	@Column(name="Password", length=30)
	private String password;
	@Column(name="Role", length=30)
	private String role;
	
	public User() {
		super();
	}

	public User(int uid, String username, String password, String role) {
		super();
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

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
