package com.user.entiry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userID;
	private String userName;
	private String userEmail;
	private long departmentID;
	
	public User() {
		super();
	}

	public User(long userID, String userName, String userEmail, long departmentID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.departmentID = departmentID;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userEmail=" + userEmail + ", departmentID="
				+ departmentID + "]";
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

}
