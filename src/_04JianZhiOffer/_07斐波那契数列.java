package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����n<=39
 * 0 1 1 2 3 5 8  ��0��Ϊ0 ��һ��Ϊ1  �����Ϊǰ����֮��
 */
public class _07쳲��������� {

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
