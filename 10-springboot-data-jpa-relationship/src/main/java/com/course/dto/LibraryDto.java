package com.course.dto;

public class LibraryDto {

	private String code;
	
	private String libraryName;
	
	private String cityCode;
	
	private String cityName;
	
	public LibraryDto() {

	}

	public LibraryDto(String code, String libraryName, String cityCode, String cityName) {
		this.code = code;
		this.libraryName = libraryName;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
