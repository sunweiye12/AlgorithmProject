package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 
 * 思路:
 */
public class _12数值整数次方 {

	@Test
	public void main() {
		double base = 3.0;		//底数
		int exponent = 2;		//次方 
		double power = Power(base, exponent);
		System.out.println(power);
	}
	
	public double Power(double base, int exponent) {
		
		return Math.pow(base, exponent);
	
	}
}
