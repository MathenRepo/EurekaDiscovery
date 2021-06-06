package com.department.VO;

import java.util.List;

import com.department.entity.Department;

public class RestTemplateResponseVO {
	
	private Department department;
	private List<UserVO> user;
	
	public RestTemplateResponseVO() {
		super();
	}

	public RestTemplateResponseVO(Department department, List<UserVO> user) {
		super();
		this.user = user;
		this.department = department;
	}

	@Override
	public String toString() {
		return "RestTemplateResponseVO [user=" + user + ", department=" + department + "]";
	}

	public List<UserVO> getUser() {
		return user;
	}

	public void setUser(List<UserVO> user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
