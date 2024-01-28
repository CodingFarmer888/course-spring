package com.course.vo;

public class Employee {
	/** ID */
	private Integer id;
	
	/** 姓名 */
	private String name;
	
	/** 地址 */
	private String address;
	
	/** 部門 */
	private String department;
	
	/** 性別 */
	private String gender;
	
	public Employee() {
		
	}
	
	public Employee(String name, String address, String department, String gender) {
		this.name = name;
		this.address = address;
		this.department = department;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
