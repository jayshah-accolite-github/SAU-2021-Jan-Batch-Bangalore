package com.jay.apps.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LoggerApplication {

	private static org.apache.log4j.Logger logger = Logger.getLogger(LoggerApplication.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Scanner sc = new Scanner(System.in);
		logger.setLevel(Level.OFF);
		System.out.println("Enter the Logger Level from Below");
		System.out.println("1. ALL");
		System.out.println("2. DEBUG");
		System.out.println("3. INFO");
		System.out.println("4. WARN");
		System.out.println("5. ERROR");
		System.out.println("6. FATAL");
		System.out.println("7. No Logging");
		System.out.println("Enter your choice");
		int ch = sc.nextInt();
		switch (ch) {
			case 1:
				logger.setLevel(Level.ALL);
				break;
			case 2:
				logger.setLevel(Level.DEBUG);
				break;
			case 3:
				logger.setLevel(Level.INFO);
				break;
			case 4:
				logger.setLevel(Level.WARN);
				break;
			case 5:
				logger.setLevel(Level.ERROR);
				break;
			case 6:
				logger.setLevel(Level.FATAL);
				break;
			case 7:
				logger.setLevel(Level.OFF);
				break;
			default:
				System.out.println("Wrong Input :(");
				break;
		}
		logger.trace("This is Trace Message..........");
		logger.debug("This is Debug Message.............");
		logger.info("This is Info Message..........");
		logger.warn("This is Warn Message.............");
		logger.error("This is Error Message............");
		logger.fatal("This is Fatal Message...............");

}
}
