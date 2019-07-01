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

/*
 * 
 */

//本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int ans = 0, x;
     for(int i = 0; i < n; i++){
         for(int j = 0; j < n; j++){
             x = sc.nextInt();
             ans += x;
         }
     } 
     System.out.println(ans);
 }
}