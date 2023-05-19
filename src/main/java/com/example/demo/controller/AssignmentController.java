package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JsonArray;
import com.example.demo.service.AssignmentService;

@RestController
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@GetMapping("/api/Fibonacci")
	public ResponseEntity<Object> getFibonacci(@RequestParam Long n) {
		return new ResponseEntity<>(assignmentService.getFibonacci(n), HttpStatus.OK);
	}

	@GetMapping("/api/ReverseWords")
	public ResponseEntity<Object> getInveretedString(@RequestParam String sentence) {
		return new ResponseEntity<>(assignmentService.getInveretedString(sentence), HttpStatus.OK);
	}

	@GetMapping("/api/TriangleType")
	public ResponseEntity<Object> getTriangleType(@RequestParam Integer a, @RequestParam Integer b,
			@RequestParam Integer c) {
		return new ResponseEntity<>(assignmentService.getTriangleType(a, b, c), HttpStatus.OK);
	}

	@PostMapping(path = "/api/makeonearray", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> getSortedArray(@RequestBody JsonArray jsonArray) {
		return new ResponseEntity<>(assignmentService.getSortedArray(jsonArray), HttpStatus.OK);
	}

}
