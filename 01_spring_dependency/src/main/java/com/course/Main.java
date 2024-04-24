package com.course;
import com.course.model.Toyota;
import com.course.model.ToyotaInheritance;

public class Main {

	public static void main(String[] args) {
		Toyota car = new Toyota();
		car.move();
		
		ToyotaInheritance carInheritance = new ToyotaInheritance();
		carInheritance.move();

	}

}
