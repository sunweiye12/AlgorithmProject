package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 	为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * 	ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 
 *思路:考虑从个位开始计算1出现的次数，个位上每10个数就会出现一个1，所以计算十位数之后出现1的次数即n模10的余数为a。
 *	假如个位数为0，那么a就为个位上1出现的次数；若等于1，那么还应该再加上1，也就是个位数为1所有数字的个数；
 *		若大于1，则a应该再加上1，即十位数出现的次数为a+1.同样的思想依次向左考虑十位数、百位数一直到最高位。
	总结一下以上的算法，可以看到，当计算右数第 i 位包含的 1 的个数时：
	取第 i 位左边（高位）的数字，乘以 10i?1，得到基础值 a。
	取第 i 位数字，计算修正值：
	如果大于 1，则结果为 a+10i?1。
	如果小于 1，则结果为 a。
	如果等于 1，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1。
 */
public class _32整数中1出现的次数88 {

	@Test
	public void main() {
		int solution = NumberOf1Between1AndN_Solution(1);
		System.out.println(solution);
	}
	
	public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;  //求商
            int b = n % i;	//求余
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
       return count;
	}
}
