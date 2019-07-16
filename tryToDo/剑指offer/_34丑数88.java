package 剑指offer;

import org.junit.Test;

/*
 * 题目:把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 		例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 		习惯上我们把1当做是第一个丑数。
 * 		求按从小到大的顺序的第N个丑数。
 * 
 * 思路1(暴力解):所谓的丑数是只能够被2 3 5作为因子的数,所以对于一个丑数不断除以2,不断除以3,不断除以5以后一定为1,
 * 		可以通过这一点来判断此数是不是丑数,可以依次判断某一个数是不是丑数.
 * 思路2(dp解):由于上面的解法需要计算所有数是不是丑数,因此时间负责度特别高,
 * 		由于丑数中只包含2,3,5的因数,所以所有的丑数都是有前面的丑数乘以2,3或5的来的
 * 		因此求第n个丑数,我们可以创建一个长度为n的数组,分别求出第1到n个丑数
 * 		那么如何从何第i个丑数求出第i+1个丑数呢?
 * 		i为之前的所有丑数都乘2得到刚好大于i位的那个数min1,
 * 		同理,i为之前的所有丑数都乘3得到刚好大于i位的那个数min2,
 * 		同理,i为之前的所有丑数都乘5得到刚好大于i位的那个数min3,则i为的下一个丑数一定为min1,min2,min3中最小的那个
 * 		实际在运算的时候没有必要将i之前的所有丑数都和2相乘,因为之前的丑数是排序的,因此我们可以一直找到这个临界位
 */
public class _34丑数88 {
	
	@Test
	public void main() {
		int num = GetUglyNumber_Solution_baoli(9); //暴力解法
		int num1 = GetUglyNumber_Solution(9); //DP解法
		System.out.println(num);
	}
	
	//动态规划解法
	public int GetUglyNumber_Solution(int size) {
		//basecase  处理异常输入
		if (size <= 0) {
			return 0;
		}
		int[] dp = new int[size]; //创建数组
		dp[0] = 1; //第一个丑数位1
		int nextIndex = 1; //指向下一个丑数的指针
		//设置三个临界值(指向dp数组想下表)
		int intMut2 = 0; //当2乘以intMut2指向的丑数刚好大于目前最大是丑数
		int intMut3 = 0;
		int intMut5 = 0;
		while(nextIndex < size){
			int minChou = Math.min(Math.min(dp[intMut2]*2, dp[intMut3]*3),dp[intMut5]*5); //获取最小值
			dp[nextIndex] = minChou;
			nextIndex++;
			while(dp[intMut2]*2 <= minChou) intMut2++;
			while(dp[intMut3]*3 <= minChou) intMut3++;
			while(dp[intMut5]*5 <= minChou) intMut5++;
		}
		return dp[size-1];
	}

	//暴力解
	public int GetUglyNumber_Solution_baoli(int size) {
		//basecase  处理异常输入
		if (size <= 0) {
			return 0;
		}
		int num = 0;		//用于返回的丑数
		int uglyFound= 0; 	//丑数计数器
		while (uglyFound < size) {
			num++;
			if (isChoushu(num)) {//当出现一个丑数计数器就加1
				uglyFound++;
			}
		}
        return num;
    }
	
	public boolean isChoushu(int num){
		//只要能整除就进行除法运算
		while(num % 2 == 0) num = num/2;
		while(num % 3 == 0) num = num/3;
		while(num % 5 == 0) num = num/5;
		//如果最后为1,说明是丑数
		return num == 1;
	}
}
