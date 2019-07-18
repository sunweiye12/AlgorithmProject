package 欢乐颂._08暴力递归_动态规划;

import org.junit.Test;

/*
 * 题目:　有n个物品，它们有各自的重量和价值，现有给定容量的背包，如何让背包里装入的物品具有最大的价值总和？
 * 
 * 思路:用v[i]表示物品价值，w[i]表示物品重量。
 * （1）定义状态dp[i][j]以j为容量的包为放入前i个物品(按i从小到大的顺序)的最大价值。
　　（2）初始化边界条件，V(0,j)=V(i,0)=0；
　　（3）对于每一个物品，有两种选择方法，能装下和不能装下。
　　　　第一，包的容量比该商品体积小，装不下，此时的价值与前i-1个的价值是一样的，即V(i,j)=V(i-1,j)；
　　　　第二，还有足够的容量可以装该商品，但装了也不一定达到当前最优价值，所以在装与不装之间选择最优的一个，
		即V(i,j)=max｛ V(i-1,j)，V(i-1,j-w(i))+v(i)｝
		其中V(i-1,j)表示不装，V(i-1,j-w(i))+v(i)	表示装了第i个商品，背包容量减少w(i)但价值增加了v(i)；
 */
public class _07_01背包问题 {

	@Test
	public void main() {
		int cap = 10 ; 		//背包总容量
		int[] wight = {5,3,4};	//每个物品的重量
		int[] value = {20,10,12}; //每个物品的价值
		int maxValue = partion(cap,wight,value);  //返回最大的价值
		System.out.println(maxValue);  //正确为32
	}

	//(输入商品的价值和重量信息)还有背包容积-->返回最大的价值
	private int partion(int cap, int[] wight, int[] value) {
		//basecase
		if(cap <= 0 || wight.length != value.length || wight.length == 0) return 0;
		//创建一个dp数组dp[x][y]  代表前x件商品,在背包体积为y时,的最大价值
		int[][] dp = new int[wight.length+1][cap+1];
		//初始化可以知道当背包容积为0或者0个商品时价值为0-->和初始化值相同,因此就不再赋值
		//dp[0][x] = dp[0][y] = 0;
		
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				if (y >= wight[x-1]) {  //如果背包的容积大于此物品的重量那思考要不要将此物品装入
					//此处注意,第x个数的重量和价值为wight[x-1] 和 value[x-1]
					dp[x][y] = Math.max(dp[x-1][y], dp[x-1][y - wight[x-1]] + value[x-1]);
				} else{
					dp[x][y] = dp[x-1][y];
				}
			}
		}
		return dp[wight.length][cap];
	}
}
