package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {

//		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");


		//location in my pc

		ApplicationContext factory = new FileSystemXmlApplicationContext("SpringDIObjectsCollections\\spring.xml");
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();

		
		
	}

}
