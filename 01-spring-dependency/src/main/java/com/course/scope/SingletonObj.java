package com.course.scope;

public class SingletonObj {
	
	private static SingletonObj instance;

	private SingletonObj() {
		
	}
	
	public static SingletonObj getInstance() {
		if (instance == null) {
			instance = new SingletonObj();
		}
		return instance;
	}
}
