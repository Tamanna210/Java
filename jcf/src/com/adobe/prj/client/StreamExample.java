package com.adobe.prj.client;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.adobe.prj.entity.Product;

public class StreamExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile"));
		products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
		products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
		products.add(new Product(912, "One Plus", 32000.00, "mobile"));
		products.add(new Product(88, "HP Printer", 19000.00, "computer"));
		products.add(new Product(224, "iPhone", 98000.00, "mobile")); // duplicate
		
		products.stream()
			.filter(p -> p.getCategory().equals("mobile"))
			.forEach(p -> System.out.println(p));
		
		
//	List<Product> mobiles = products.stream()
//		.filter(p -> p.getCategory().equals("mobile"))
//		.collect(Collectors.toList());
//	
//		for(Product p : mobiles) {
//			System.out.println(p);
//		}
		
// 		ForkJoin algorithm
//		products.stream()
		products.parallelStream()
			.map(elem -> elem.getName())
			.forEach(elem -> System.out.println(elem));
		
		System.out.println("**********");
		
		System.out.println("Reduce: sum of price of products..");
		double total = products.parallelStream()
//			.filter(p -> p.getCategory().equals("mobile"))
			.map(elem -> elem.getPrice())
			.reduce(0.0 , (v1, v2) ->  v1 + v2);
		
		System.out.println("Total :" + total);
		
		DoubleSummaryStatistics stats = 
				products.stream()
				.collect(Collectors.summarizingDouble(p -> p.getPrice()));
		
		System.out.println("Max : " + stats.getMax());
		System.out.println("Min : " + stats.getMin());
		System.out.println("Total : " + stats.getSum());
		System.out.println("Count : " + stats.getCount());
		System.out.println("Avg : " + stats.getAverage());
		
		System.out.println("*************");
		
		Map<String, List<Product>> prdMap = 
				products.stream().collect(Collectors.groupingBy(p -> p.getCategory()));
		
		List<Product> mbs = prdMap.get("computer");
		mbs.forEach(System.out::println); // method reference
	}

}
