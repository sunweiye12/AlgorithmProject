package _02分类算法._08暴力递归_动态规划;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *【题目】给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，
 * 		求换钱有多少种方法。
 *【举例】 arr=[5,10,25,1]，aim=0。	组成0元的方法有1种，就是所有面值的货币都不用。所以返回1。
 *		arr=[5,10,25,1]，aim=15。
 *		组成15元的方法有6种，分别为3张5元、1张10元+1张5元、1张10元+5张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所以返回6。
 *		arr=[3,5]，aim=2。	任何方法都无法组成2元。所以返回0。
 *
 * 优化解决方案->(记忆化搜索):由于上面的解法计算了大量的重复操作,因此可以通过创建一个缓存结构来将每次计算的结果进行存储,
 * 		然后在需求时,在缓存结构中查找.
 */
public class _01换钱的方法数_记忆化搜索 {
	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num2 = baoliyouhua(arr,aim);
		System.out.println(num2);
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
		//创建一个人用于缓存的map结构其中key为:index_aim 而value为index后组成aim的方法数
		Map<String, Integer> map = new HashMap<String, Integer>();
		//定义返回结果
		int res = 0; 
		if (index == arr.length) {
			return res = arm == 0 ? 1 : 0;
		}
		int count = arm/arr[index];
		for (int i = 0; i <= count; i++) { 
			//依次计算第一个位置为不同值时返回的方法数的和
			String key = String.valueOf(index+1)
					+"_"+String.valueOf(arm - arr[index] * i);
			if(map.containsKey(key)){
				res += map.get(key);
			} else{
				res += baoliyouhuaPartion(arr, index + 1, arm - arr[index] * i);
				map.put(key, res);
			}
		}
		return res;
	}
}