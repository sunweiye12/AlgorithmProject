package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 
 * 思路:有题意可以得到 1 1 2 4 8 16 ... (第一个为n==0时)
 * 		因此我们可以得出,从n==2开始 后面的都是前面的两倍
 * dp版:创建一个一位数组长度为n+1  dp[0]和dp[1]==1
 * 		其余的为前面数的二倍   最后返回dp[n]
 * 
 */
public class _09变态跳台阶 {
	@Test
	public void main() {
		System.out.println(JumpFloor(3));
	}
	
	public int JumpFloor(int target) {
		//basecase
		if (target == 0 || target == 1) {
			return 1;
		}
		return 2 * JumpFloor(target - 1);

    }
	
	public int JumpFloorDB(int n) {
		if (n<=1) {
			return 1;
		}
		//DB版
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = 2 * dp[i-1];
		}
		return dp[n];
    }

}
