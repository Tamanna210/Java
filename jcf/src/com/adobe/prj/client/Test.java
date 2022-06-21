package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(33,5,10,4,50);
		
		List<Integer> output = filter(list, elem -> elem % 2 != 0);
		
		System.out.println(output);
	}
	
	public  static <T> List<T> filter(List<T> nos, Predicate<T> predicate) {
		List<T> out = new ArrayList<>();
			for(T elem : nos) {
				if(predicate.test(elem)) {
					out.add(elem);
				}
			}
		return out;
	}
}
