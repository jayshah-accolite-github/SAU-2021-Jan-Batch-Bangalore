package com.jay.apps.junit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JunitApplicationTests {

	@Test
	public void test1() {
		LeapYear object = new LeapYear();
		boolean res = object.isLeapYear(2020);
		assertEquals(true, res);
	}

	@Test
	public void test2() {
		LeapYear object = new LeapYear();
		boolean res = object.isLeapYear(2021);
		assertEquals(false, res);
	}

	@Test
	public void test3() {
		LeapYear object = new LeapYear();
		boolean res = object.isLeapYear(2022);
		assertEquals(false, res);
	}

	@Test
	public void test4() {
		LeapYear object = new LeapYear();
		boolean res = object.isLeapYear(-2020);
		assertEquals(false, res);
	}

	@Test
	public void test5() {
		LeapYear object = new LeapYear();
		boolean res = object.isLeapYear(2000);
		assertEquals(true, res);
	}
}
