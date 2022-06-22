package com.adobe.prj.client;

import java.util.stream.IntStream;

public class MethodRef {
	public static boolean isEven(int x) {
		return x % 2 == 0;
	}
	public static void main(String[] args) {
		IntStream.of(3,7,11,2,10,25)
			.filter(MethodRef::isEven)
 			//.filter(p -> MethodRef.isEven(p))
			.forEach(System.out::println);
		
		
	}

}
