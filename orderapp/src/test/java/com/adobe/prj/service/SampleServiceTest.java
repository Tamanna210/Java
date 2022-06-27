package com.adobe.prj.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SampleServiceTest {

	@Test
	public void testAdd() {
		SampleService service = new SampleService();
		int actual = service.add(4, 5);
		int expected = 9;
		assertEquals(expected, actual);
	}

	@Test
	public void testSubtract() {
		SampleService service = new SampleService();
		int actual = service.subtract(14, 4);
		int expected = 10;
		assertEquals(expected, actual);
	}

}
