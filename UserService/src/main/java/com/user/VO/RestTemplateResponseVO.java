package com.user.VO;

import com.user.entiry.User;

public class RestTemplateResponseVO {
	
	private User user;
	private DepartmentVO department;
	
	public RestTemplateResponseVO() {
		super();
	}

	public RestTemplateResponseVO(User user, DepartmentVO department) {
		super();
		this.user = user;
		this.department = department;
	}

	@Override
	public String toString() {
		return "RestTemplateResponseVO [user=" + user + ", department=" + department + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DepartmentVO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}

}
