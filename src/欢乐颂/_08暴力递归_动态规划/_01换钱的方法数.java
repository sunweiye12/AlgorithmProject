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
 * 优化解决方案->(记忆化搜索):由于上面的解法计算了大量的重复操作,因此可以通过创建一个缓存结构来将每次计算的结果进行存储,然后在
 * 		需求时,在缓存结构中查找.
 * 
 * DP解决方案:通过一个二维数组结构dp来存放所有的结果集,通过basecase来设置已知的位置,然后通过以来关系推导出其它的结果.直到最后的结果可以得出
 */
public class _01换钱的方法数 {
	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num1 = baoli(arr,aim);
		int num2 = baoliyouhua(arr,aim);
		int num3 = dppartion(arr,aim);
		System.out.println(num1);
		System.out.println(num2);
	}

	//利用动态规划来解决此问题
	private int dppartion(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		return 0;
	}

	//优化解决方案
	private int baoliyouhua(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		return baoliyouhuaPartion(arr,0,aim);
	}

	//暴力方法的优化解决方案
	private int baoliyouhuaPartion(int[] arr, int index, int arm) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int res = 0; //定义返回结果
		if (index == arr.length) {
			return res = arm == 0 ? 1 : 0;
		}
		for (int i = 0; arr[index] * i <= arm; i++) { //依次计算第一个位置为不同值时返回的方法数的和
			String key = String.valueOf(index+1)
					+"_"+String.valueOf(arm - arr[index] * i);
			if(map.containsKey(key)){
				res += map.get(key);
			} else{
				res += baoliPartion(arr, index + 1, arm - arr[index] * i);
				map.put(key, res);
			}
		}
		return res;
	}

	//暴力解法
	private int baoli(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		return baoliPartion(arr,0,aim);
	}
	
	/*
	 * 暴力递归过程
	 * arr:是原始数组,不变
	 * index:是指从index位置开始后面的前可以随便用
	 * aim :代表要拼出的目的钱数
	 * 返回值时方法数
	 */
	private int baoliPartion(int[] arr, int index, int aim) {
		int res = 0; 	//定义返回结果
		if (index == arr.length) {
			return res = aim == 0 ? 1 : 0;
		}
		for (int i = 0; arr[index] * i <= aim; i++) { //依次计算第一个位置为不同值时返回的方法数的和
			res += baoliPartion(arr, index + 1, aim - arr[index] * i);
		}
		return res;
	}
}