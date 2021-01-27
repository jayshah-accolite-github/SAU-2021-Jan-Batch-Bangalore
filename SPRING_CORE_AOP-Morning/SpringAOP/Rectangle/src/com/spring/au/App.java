package com.spring.au;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {

		ApplicationContext config = new AnnotationConfigApplicationContext(AppConfig.class);
		Rectangle rectangle = (Rectangle) config.getBean("rectangleObj");
		rectangle.draw();
	}

}
