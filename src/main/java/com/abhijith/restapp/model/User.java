/**
 * 
 */
package com.abhijith.restapp.model;

/**
 * @author asj
 *
 */
public class User {
	
	private Integer userid;
	private String username;
	private String password;
	
	/*
	 * 1- general user
	 * 2- CSR (Customer Service Representative)
	 * 3- admin
	 */
	private Integer usertype;
	private static Integer userCounter = 100;
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Integer usertype) {
		userCounter++;
		this.userid = userCounter;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	
	public User(Integer userid, String username, Integer usertype) {		
		
		this.userid = userid;
		this.username = username;
		this.usertype = usertype;
	}
	
	
	public User(Integer userid, Integer usertype) {
		this.userid = userid;
		this.usertype = usertype;
	}
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public Integer getUsertype() {
		return usertype;
	}

	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

}
