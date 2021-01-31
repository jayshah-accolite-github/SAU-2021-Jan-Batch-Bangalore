package com.jay.apps.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);

			Scanner sc = new Scanner(System.in);
			LeapYear leapYear = new LeapYear();
			int year = sc.nextInt();
			if (leapYear.isLeapYear(year)) {
				System.out.println("This year is a Leap Year :)");
			} else {
				System.out.println("This year is not a Leap Year :( ");
			}




	}

}
