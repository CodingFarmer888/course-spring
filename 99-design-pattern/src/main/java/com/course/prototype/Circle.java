package com.course.prototype;

public class Circle extends Shape {
	
    public int radius;

    public Circle() {
    	
    }

    public Circle(Circle target) {
        super(target);
        this.radius = target.radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Circle)) return false;
        Circle shape2 = (Circle) object2;
        return shape2.radius == radius;
    }
}
