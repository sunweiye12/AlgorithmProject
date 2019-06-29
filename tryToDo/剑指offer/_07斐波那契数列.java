package 剑指offer;

import org.junit.Test;

/*
 * 题目:大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 0 1 1 2 3 5 8  第0项为0 第一项为1  其余的为前两项之和
 */
public class _07斐波那契数列 {

	@Test
	public void main() {
		System.out.println(Fibonacci(6));
	}
	
	public int Fibonacci(int n) {
		//basecase
		if (n == 0) return 0;
		if (n == 1) return 1; 
		return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
