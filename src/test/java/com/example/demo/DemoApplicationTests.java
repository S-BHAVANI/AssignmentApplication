package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.JsonArray;
import com.example.demo.model.ResponseArrayEntity;
import com.example.demo.service.AssignmentService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AssignmentService assignmentService;

	@Test
	void getFibonacciTest() {
		assertEquals(2L, assignmentService.getFibonacci(1L));
		assertEquals(-1L, assignmentService.getFibonacci(-1L));
		assertEquals(144L, assignmentService.getFibonacci(4L));
	}

	@Test
	void getInveretedStringTest() {
		assertEquals("woh era uoy", assignmentService.getInveretedString("how are you"));
	}

	@Test
	void getTriangleTypeTest() {
		assertEquals("InvalidInput", assignmentService.getTriangleType(0, 0, 0));
		assertEquals("Not a Triangle", assignmentService.getTriangleType(10, 2, 3));
		assertEquals("Equilateral Triangle", assignmentService.getTriangleType(10, 10, 10));
		assertEquals("Right Triangle", assignmentService.getTriangleType(13, 12, 5));
		assertEquals("Scalene Triangle", assignmentService.getTriangleType(12, 11, 10));
		assertEquals("Isosceles Triangle", assignmentService.getTriangleType(12, 12, 10));
	}

	@Test
	void getSortedArrayTest() {
		JsonArray jsonArray = new JsonArray();
		jsonArray.setArray1(new int[] { 1, 2, 3, 4 });
		jsonArray.setArray2(new int[] { 3, 4, 5, 6 });
		jsonArray.setArray3(new int[] { 6, 1, 3, 11 });
		ResponseArrayEntity response = new ResponseArrayEntity();
		response.setArray(new int[] { 1, 2, 3, 4, 5, 6, 11 });
		assertEquals(response, assignmentService.getSortedArray(jsonArray));
	}

}
