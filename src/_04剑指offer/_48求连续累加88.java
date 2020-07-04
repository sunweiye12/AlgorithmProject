package _04剑指offer;

import org.junit.Test;

/*
 * 题目:求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 思路:	1.需利用逻辑与的短路特性实现递归终止。 
 * 		2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
 * 		3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
 */
public class _48求连续累加88 {

	@Test
	public void main() {
		int sum = Sum_Solution(5);
		System.out.println(sum);
	}
	public int Sum_Solution(int n) {
		int sum = n;
		//逻辑与的短路特性,也就是说只有当n>0时会判断后面的(即执行递归),当n=09时直接返回0
        boolean flag = (n>0) && ((sum+=Sum_Solution(n-1))>0); 
        return sum;
    }
}
