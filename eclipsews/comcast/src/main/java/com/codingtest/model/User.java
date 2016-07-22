package com.codingtest.model;

public class User {
	private String userName;
	private String emailAddress;
	//keeping it simple
	private String dateRegistered;
	
	public User(String userName, String emailAddress, String dateRegistered){
		this.userName = userName;
		this.emailAddress = emailAddress;
		this.dateRegistered = dateRegistered;
	}
	public User(){		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(String dateRegistered) {
		this.dateRegistered = dateRegistered;
	}


}
