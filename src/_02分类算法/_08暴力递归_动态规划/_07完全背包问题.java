package _02分类算法._08暴力递归_动态规划;
import org.junit.Test;
/*
 * 题目:有N种物品和一个容量为cap的背包，每种物品都有无限件可用。
 * 		第i种物品的重量是wight[i]，价值是value[i]。
 * 		求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 
 * 思路：之前写了01背包问题，现在写完全背包问题。和01背包不同的是，完全背包不限定某种物品的件数，
 * 		可以装0,1,2，...，而01背包只有装与不装的区别。但是思考问题的方式还是一样的
 */
public class _07完全背包问题 {
	@Test
	public void main() {
		int cap = 10 ; 			//背包总容量
		int[] wight = {5,3,4};	//每个物品的重量
		int[] value = {20,10,12}; //每个物品的价值
		int maxValue = partion(cap,wight,value);  //返回最大的价值
		System.out.println(maxValue);  //正确为40
	}

	//完全别抱问题
	private int partion(int cap, int[] wight, int[] value) {
		//basecase
		if(cap <= 0 || wight.length != value.length || wight.length == 0) return 0;
		//创建一个dp数组,dp[x][y]  代表前x件商品,在背包体积为y时,的最大价值
		int[][] dp = new int[wight.length+1][cap+1];
		//初始化可以知道当背包容积为0或者0个商品时价值为0-->和初始化值相同,因此就不再赋值
		//dp[0][x] = dp[0][y] = 0;
		
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				//和01背包的区别就在这里，01背包只有两种状态：放与不放
				//而完全背包可以放0到k个物品i，同样是取最大值
				int count = y/wight[x-1]; //**此背包可以盛放多少个第x个物品
				for (int i = 0; i <= count; i++) { //从放0个到放count个,得出最大的
					dp[x][y] = Math.max(dp[x-1][y], 
							dp[x-1][y - i * wight[x-1]] + i * value[x-1]);
				}
			}
		}
		return dp[wight.length][cap];
	}
}
