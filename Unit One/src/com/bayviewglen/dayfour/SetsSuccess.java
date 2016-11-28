package com.bayviewglen.dayfour;

import java.util.*;

public class SetsSuccess {
	public static void main(String[] args) {
		Set<String> aSet = new HashSet<String>();
		aSet.add("element one");
		
		List<String> list = new ArrayList<String>();
			list.add("A");
			list.add("B");
			list.add("B");
			list.add("B");
			list.add("B");
			list.add("C");
			list.add("E");
			
		Set<String> bSet = new HashSet<String>(list);
		System.out.println(bSet);
		
		Map<String, String> myMap = new HashMap<String, String>();
		String[] strings = {"Rodin", "Habibi", "is", "bad", "cuz", "mad"};
		
		for(String s : strings) {
			myMap.put(s.substring(0,1), s);
		}
		
	}
}
