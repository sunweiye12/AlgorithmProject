package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test1 {

	public static void main(String[] args) {
		List<Integer> list = new  ArrayList<Integer>();
		list.add(1);
		list.add(6);
		list.add(8);
		list.add(5);
		list.add(3);
		Collections.sort(list, new Comparable<T>(){});
		System.out.println(list);
		
	}
}
