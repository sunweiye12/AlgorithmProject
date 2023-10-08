package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 		不能使用除法。(即所有数相乘除了第i个数)
 * 
 * 思路:直观法,每次求B[i]时只需要将数组A中对应的元素相乘(不包括第i个元素)
 */
public class _52构建成绩数组 {

	@Test
	public void main() {
		int[] A = {1,2,3};
		int[] B = multiply(A);
		for (int i : B) {
			System.out.print(i+" ");
		}
	}
	
	public int[] multiply(int[] A) {
		if (A == null || A.length == 0) {
			return new int[] {};
		}
		int[] B = new int[A.length];
		for (int i = 0; i < B.length; i++) {
			int tem = A[i];
			A[i] = 1;
			partion(B,i,A); //调用方法,使得B[i]为A中所欲元素的成绩
			A[i] = tem;
		}
		return B;
    }

	//使B[i]所对应的元素为A数组虽有元素的乘积
	private void partion(int[] b, int i, int[] a) {
		b[i] = 1;
		for (int j = 0; j < a.length; j++) {
			b[i] *= a[j];
		}
	}
}
