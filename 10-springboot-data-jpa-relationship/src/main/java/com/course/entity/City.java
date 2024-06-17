package com.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** 區碼 */
	@Column(unique = true)
	private String code;
	
	private String name;
	
	/**
	 * 從 City 往 Library 的關聯，情境上不使用
	 */
	// @OneToMany(mappedBy = "city")
	// private List<Library> libraries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//	public List<Library> getLibraries() {
	//		return libraries;
	//	}
	//
	//	public void setLibraries(List<Library> libraries) {
	//		this.libraries = libraries;
	//	}
	
}
