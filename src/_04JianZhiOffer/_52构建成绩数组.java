package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]��
 * 		����ʹ�ó�����(����������˳��˵�i����)
 * 
 * ˼·:ֱ�۷�,ÿ����B[i]ʱֻ��Ҫ������A�ж�Ӧ��Ԫ�����(��������i��Ԫ��)
 */
public class _52�����ɼ����� {

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
			partion(B,i,A); //���÷���,ʹ��B[i]ΪA������Ԫ�صĳɼ�
			A[i] = tem;
		}
		return B;
    }

	//ʹB[i]����Ӧ��Ԫ��ΪA��������Ԫ�صĳ˻�
	private void partion(int[] b, int i, int[] a) {
		b[i] = 1;
		for (int j = 0; j < a.length; j++) {
			b[i] *= a[j];
		}
	}
}
