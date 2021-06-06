package com.user.VO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DepartmentVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long departmentID;
	private String departmentName;
	private String departentAddress;
	private String departmentCode;
	
	public DepartmentVO() {
		super();
	}

	public DepartmentVO(long departmentID, String departmentName, String departentAddress, String departmentCode) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departentAddress = departentAddress;
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", departentAddress="
				+ departentAddress + ", departmentCode=" + departmentCode + "]";
	}

	public long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartentAddress() {
		return departentAddress;
	}

	public void setDepartentAddress(String departentAddress) {
		this.departentAddress = departentAddress;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

}
