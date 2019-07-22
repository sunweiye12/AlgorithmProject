package 欢乐颂._08暴力递归_动态规划;
import org.junit.Test;
/*
 * 题目:有N种物品和一个容量为cap的背包，每种物品都有无限件可用。
 * 		第i种物品的重量是wight[i]，价值是value[i],每个物品 个数为count[i]。
 * 		求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 
 * 思路:可以通过完全背包延伸过来
 */
public class _07多重背包问题 {
	@Test
	public void main() {
		int cap = 10 ; 		//背包总容量
		int[] wight = {5,3,4};	//每个物品的重量
		int[] value = {20,10,12}; //每个物品的价值
		int[] count = {2,1,1};  //每个物品的数目 
		int maxValue = partion(cap,wight,value,count);  //返回最大的价值
		System.out.println(maxValue);  //正确为40
	}

	public int partion(int cap, int[] wight, int[] value, int[] count) {
		//basecase
		if(cap <= 0 || wight.length != value.length || wight.length == 0) return 0;
		//创建一个dp数组dp[x][y]  代表前x件商品,在背包体积为y时,的最大价值
		int[][] dp = new int[wight.length+1][cap+1];
		//初始化可以知道当背包容积为0或者0个商品时价值为0-->和初始化值相同,因此就不再赋值
		//dp[0][x] = dp[0][y] = 0;
		
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				//和完背包的区别就在这里，完全背包可以放无限个,所以只要包能装得下就无限放
				//而多重背包每一个物品有自己的数量，做多可以放count[x-1]个
				int temCount = y/wight[x-1]; //**此背包可以盛放多少个第x个物品
				temCount = Math.min(temCount, count[x-1]); //与x物品的数目,取小值
				for (int i = 0; i <= temCount; i++) { //从放0个到放count个,得出最大的
					dp[x][y] = Math.max(dp[x][y], 
							dp[x-1][y - i * wight[x-1]] + i * value[x-1]);
				}
			}
		}
		return dp[wight.length][cap];
	}

	
}
