package com.adobe.prj.utility;

public class Utility {
	// OCP
	public static void sort(IComparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				IComparable temp;
				if(elems[i].compare(elems[j]) > 0) { // polymorphism
					temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}
}
