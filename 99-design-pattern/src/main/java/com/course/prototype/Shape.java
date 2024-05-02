package com.course.prototype;

public abstract class Shape {

	public Integer x;
	
	public Integer y;
	
	public String color;

	public Shape() {
		
	}
	
	public Shape(Shape source) {
		this.x = source.x;
		this.y = source.y;
		this.color = source.color;
	}
	
	public abstract Shape clone();
	
}
