package com.adobe.prj.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("John Smith", 1234); //entry
		map.put("Lisa Smith", 8976); 
		map.put("Sandra Dee", 1234); //entry
	
		System.out.println(map.get("Sandra Dee"));
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println("*********");
		
		map.forEach((key,value) -> {
			System.out.println(key + " : " + value);
		});
		
		map.put("Lisa Smith", 9821); // overwrite the value
		
		map.remove("Sandra Dee");
		
	}

}
