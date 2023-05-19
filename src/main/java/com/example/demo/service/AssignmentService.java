package com.example.demo.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.model.JsonArray;
import com.example.demo.model.ResponseArrayEntity;

@Service
public class AssignmentService {

	public Long getFibonacci(Long n) {
		return getFibonacciSequence(n);
	}

	private Long getFibonacciSequence(Long n) {
		if (n < 1)
			return n;

		if (n == 1)
			return 2L;

		return ((4 * getFibonacciSequence(n - 1)) + getFibonacciSequence(n - 2));
	}

	public String getInveretedString(String sentence) {
		String[] arrString = sentence.trim().split(Pattern.quote(" "));
		StringBuilder builder = new StringBuilder();
		int length = arrString.length;

		int index = 0;
		while (index < length) {
			StringBuilder eachWord = new StringBuilder(arrString[index]).reverse();
			builder.append(eachWord).append(" ");
			index++;
		}
		return builder.toString().trim();
	}

	public String getTriangleType(Integer a, Integer b, Integer c) {
		String triangleType = null;
		if (a <= 0 || b <= 0 || c <= 0)
			triangleType = "InvalidInput";
		else if (a >= (b + c) || c >= (b + a) || b >= (a + c))
			triangleType = "Not a Triangle";
		else if (a.equals(b) && b.equals(c))
			triangleType = "Equilateral Triangle";
		else if (((a * a) + (b * b)) == (c * c) || ((a * a) + (c * c)) == (b * b) || ((c * c) + (b * b)) == (a * a))
			triangleType = "Right Triangle";
		else if (!Objects.equals(a, b) && !Objects.equals(b, c) && !Objects.equals(c, a))
			triangleType = "Scalene Triangle";
		else
			triangleType = "Isosceles Triangle";
		return triangleType;
	}

	public ResponseArrayEntity getSortedArray(JsonArray jsonArray) {
		Set<Integer> set = new HashSet<>();
		for (int num : jsonArray.getArray1()) {
			set.add(num);
		}
		for (int num : jsonArray.getArray2()) {
			set.add(num);
		}
		for (int num : jsonArray.getArray3()) {
			set.add(num);
		}
		ResponseArrayEntity response = new ResponseArrayEntity();
		response.setArray(set.stream().mapToInt(Integer::intValue).toArray());
		return response;
	}

}
