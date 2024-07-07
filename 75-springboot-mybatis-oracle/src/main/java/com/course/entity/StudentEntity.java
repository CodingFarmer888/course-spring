package com.course.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUEDNT_ID_SEQ_GEN")
    @SequenceGenerator(name = "STUEDNT_ID_SEQ_GEN", sequenceName = "STUDENT_SEQ", allocationSize = 1)
	private Long id;
	
	private String name;
	
	private String sex;
	
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
