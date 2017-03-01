package com.Commerce.bean;

public class UserBean {
	
	//attributes
	private int id;
	private String password;
	private String fullName;
	private String dateOfBirth;
	private String email;
	private String job;
	private double creditNumber;
	private  AdminEnum isAdmin;
	
	@Override
	public String toString() {
		return "password : " + password + " fullName :" + fullName + " dateOfBirth :" + dateOfBirth + " email :"
				+ email + " job :" + job + " creditNumber :" + creditNumber ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getCreditNumber() {
		return creditNumber;
	}
	public void setCreditNumber(double creditNumber) {
		this.creditNumber = creditNumber;
	}
	public AdminEnum getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(AdminEnum isAdmin) {
		this.isAdmin = isAdmin;
	}


		
	
}
