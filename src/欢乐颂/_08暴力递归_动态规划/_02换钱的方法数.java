package 欢乐颂._08暴力递归_动态规划;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 * 【题目】给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，
 * 		求换钱有多少种方法。
 *【举例】arr=[5,10,25,1]，aim=0。
 *		组成0元的方法有1种，就是所有面值的货币都不用。所以返回1。
 *	arr=[5,10,25,1]，aim=15。
 *		组成15元的方法有6种，分别为3张5元、1张10元+1张5元、1张10元+5张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所以返回6。
 *	arr=[3,5]，aim=2。
 *		任何方法都无法组成2元。所以返回0。
 *
 * 暴力递归解法:以[5,10,25,1]，aim=15。为例此枚举
 * 			使用0个5: 10,25,1 组成  15 的方法数为 - a
 * 			使用1个5: 10,25,1 组成  10 的方法数为 - b
 * 			使用2个5: 10,25,1 组成  5  的方法数为 - c
 * 			使用3个5: 10,25,1 组成  0  的方法数为 - d
 * 		然后依次将 a b c d 加起来.
 * 
 * 优化方案:(记忆化搜索:加缓存)
 * 	上面的暴力递归法做了好多无效操作,例如两个5元和0个10元  要求25和1组成5元的方法数
 * 							在计算0个5元和1个10元  也要求25和1组成5元的方法数 类似还有
 * 	因此基于这种重复操作,我们就可以提出一种优化的策略,每次计算完一个结果之后我把他存岛一个集合中,在每次计算的时候想去查一下,如果有就不用计算直接得到
 * 	如果没有在进行计算,返回,并加入到集合    
 * 	注:用于处理无后效性问题:即到达某一状态和他怎么到达的没有关系,
 * 		例如上面:两个5元和0个10元  和  0个5元和1个10元 都要求25和1组成5元的方法数这个结果不依赖与前面的状态
 * 
 * DP解法:由于只要是index和aim这两个参数固定了,他的返回值就确定了;
 * 		因此通过两个参数我们可以建立一个二维数组(即DP数组)-->index范围是[0,n] aim范围是[0,aim]; (通过分子参数的变化范围可以得到dp数组)
 * 		明确我们要求的位置;依据这个二维的数组表可以通过递归的截止条件得出,一些数据,然后通过逻辑推导出其余的位置
 * 		
 * 
 */ 
public class _02换钱的方法数 {

	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num1 = baoli(arr,aim);
		int num2 = baoliyouhua(arr,aim);
		int num3 = pd(arr,aim);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
	
	//递归解法
	private int pd(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		//创建dp数组
		int[][] dp = new int[arr.length][aim+1]; //第一个参数表示从index位置起,第二各参数是拼出的aim,dp中丛芳的是结果
		//将已知结果添加到dp(不依赖其他位置就能得到的值)
		//当aim为0时index为几都只有一种结果->填好
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		//只用第一个金额,可以拼出那些aim,并且只有一种结果->填好
		for (int i = 1; arr[0] * i <= aim; i++) {
			dp[0][arr[0] * i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i-1][j];
				dp[i][j] += j - arr[i] >= 0?dp[i][j-arr[i]] : 0 ;
			}
		}
		return dp[arr.length -1][aim];
	}

	//优化暴力解法
	private int baoliyouhua(int[] arr, int aim) {
		//输入的basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return baoliyouhuaPartion(arr,0,aim);	//调用递归方法返回
	}
	
	// 优化暴力递归过程
	private int baoliyouhuaPartion(int[] arr, int index, int aim) {
		int res = 0; //声明返回结果
		//Key为"index_aim"(这两个参数决定以个状态) Value为index和aim是返回的方法数
		Map<String, Integer> map = new HashMap<String, Integer>();//声明一个map来做缓存
		if (index == arr.length) {
			return res = aim == 0 ? 1 : 0;
		}
		
		for (int i = 0; arr[index] * i <= aim; i++) {
			String key = String.valueOf(index+1) +"_"+ String.valueOf(aim - arr[index] * i); //下一个要求的值
			if (map.containsKey(key)) {	//如果已经存在则直接去除
				res += map.get(key);
			}else{						//如果不存在则计算后添加大map中
				res += baoliPartion(arr, index + 1, aim - arr[index] * i); 
				map.put(key, res);
			}
		}
		return res;
	}

	//暴力解法
	private int baoli(int[] arr, int aim) {
		//输入的basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return baoliPartion(arr,0,aim);	//调用递归方法返回
	}
	
	/*
	 * 暴力递归过程
	 * arr:是原始数组,不变
	 * index:是指从index位置开始后面的前可以最易用
	 * arm :代表要拼出的目的钱数
	 * 返回值时方法数
	 */
	private int baoliPartion(int[] arr, int index, int aim) {
		int res = 0; //声明返回结果
		//定义结束条件,当index=arr.length是代表没有钱时的情况(index=arr.length-1代表只有最后一张钱时)
		//如果来到最后没有钱的时候,目标aim为0,则表明找到了一种有效的划分
		if (index == arr.length) {		//aim=0 带表此方案成立; aim!=0 代表此方法不可行
			return res = aim == 0 ? 1 : 0;
		}
		 //依次计算第一个金额使用不同个时,剩余金额返回的方法数的和(只要当前金额*使用的个数小于等于总金额就可以继续)
		for (int i = 0; arr[index] * i <= aim; i++) {
			res += baoliPartion(arr, index + 1, aim - arr[index] * i);  //方法数依次累加
		}
		return res;
	}
}
