package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η�
 * 
 * ˼·:
 */
public class _12��ֵ�����η� {

	@Test
	public void main() {
		double base = 3.0;		//����
		int exponent = 2;		//�η� 
		double power = Power(base, exponent);
		System.out.println(power);
	}
	
	public double Power(double base, int exponent) {
		
		return Math.pow(base, exponent);
	
	}
}
