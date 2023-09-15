package com.codejunction.java8.Java8Example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExample {

	public static void main(String[] args) {

		// Write a program to square each even number in a list in java 8.

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		List<Integer> squareList = list.stream()
				.filter(n -> n % 2 == 0).map(n -> n * n)
				.collect(Collectors.toList());

		System.out.println(squareList);

		System.out.println(list);
	}

}