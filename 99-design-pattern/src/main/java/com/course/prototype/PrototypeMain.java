package com.course.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeMain {

	public static void main(String[] args) {
		
        List<Shape> shapes = new ArrayList<>();
        List<Shape> shapesCopy = new ArrayList<>();

        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        shapes.add(anotherCircle);
        
        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 20;
        rectangle.color = "blue";
        
        shapes.add(rectangle);


        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }
        
        for (int i = 0; i < shapes.size(); i += 1) {
        	System.out.println(shapes.get(i).equals(shapesCopy.get(i)));
        }
        
	}

}
