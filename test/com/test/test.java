package com.test;

public class test {

	public static void main(String[] args) {
		double i = 0.0;
		double y = 2.5 * Math.cos(Math.asin(i/11));
		for (double j = 0; j <= 10; j += 0.1) {
			System.out.println(j + " " + 2.5 * Math.cos(Math.asin(j/11)));
		}
	}
}
