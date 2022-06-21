package com.adobe.prj.client;

import com.adobe.prj.utility.Computation;

public class ComputationExample {

	public static void main(String[] args) {
		// anonymous class
		Computation<Integer> c1 = new Computation<Integer>() {
			@Override
			public Integer compute(Integer x, Integer y) {
				return x + y;
			}
		};
		System.out.println(c1.compute(4, 5));
		
		// java 8 lambda expression ==> can be used only if one method exists in interface
		Computation<Double> c2 = (Double d1, Double d2) -> {
			return d1 - d2;
		};
		
		System.out.println(c2.compute(50.4, 5.2));
		
		Computation<Double> c3 = (d1,d2) -> d1 * d2;
		System.out.println(c3.compute(50.4, 5.2));
	}

}
