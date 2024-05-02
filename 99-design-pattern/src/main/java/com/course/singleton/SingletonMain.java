package com.course.singleton;

public class SingletonMain {

	public static void main(String[] args) {

		SingletonUtil util = SingletonUtil.getInstance();
		util.show();
		
		SingletonUtil util2 = SingletonUtil.getInstance();
		util2.show();
	}

}
