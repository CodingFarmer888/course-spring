package com.course.prototype;

public class Rectangle extends Shape {
	
	public Integer width;
	
	public Integer height;
	

	public Rectangle() {

	}

	public Rectangle(Rectangle source) {
		super(source);
		this.width = source.width;
		this.height = source.height;
	}


	@Override
	public Shape clone() {
		return new Rectangle(this);
	}
	
	@Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Rectangle)) return false;
        Rectangle shape2 = (Rectangle) object2;
        return shape2.width == width && shape2.height == height;
    }

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}

}
