package _02分类算法._10经典问题;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/*
 * 此题解决了求累积和为固定值的最长子数组长度:衍生题目***********************重要
 * 	1.一个数组中有奇数和偶数,求奇数和偶数个数相等的最长子数组长度	-->将奇数变为-1,偶数变为1,求累加和为0的最长子数组长度
 *  2.一个数组中含有0和1,求0和1个数相等的最长子数组长度   		-->将0变成-1,求累加和为0的最长子数组长度
 *  3.一个数组中含有0和1还有2,求1和2个数相等的最长子数组长度  	-->将2变成-1,求累加和为0的最长子数组长度
 *  
 * 题目:给定你一个int类型的数组,和一个arm值.返回子数组中所有数和为arm的最长的子数组的长度.
 * 例如:int arr = {7,3,2,1,1,7,7,7}  int arm = 7				int arr = {7,3,2,1,1,7,-6,-1,7}
 * 因为和为7的最长子数组为{3,2,1,1},则返回的 4
 * 
 * 暴力解思路:求出所有子数组,分别计算每个子数组的和时是否为arm,然后在保留一个最大长度进行返回
 * 经典思路:在一个数组中.我们先解决以某一个数结尾的子数组中累加和为arm的最长子数组,
 * 		假设求第100个数结尾最长子数组,和为arm等于80,假如知道这100个数的和为200,那从第一个数开始累加,当加到一个数时和为120,
 * 		则下一个数到第一百个数的和就是80;且这个长度是最长的;
 * 		根据此思路可以设计程序,上面给出了arr数组和arm值.
 * 		你自己定义一个sum来记录从0位置开始的累加和.
 * 		定义一个map双列集合.key为每次累加后的sum, value为第一次出现sum所对应的数组下标
 * 		每次累加后将数据添加到map集合中,然后来判断sum-arm(即上面的120)是否在集和Map中存在key,
 * 		如果存在则表明从它的下一个数到当前下标的数累加和为arm
 */
public class _02累加和为指定值的最长子数组长度_1 {
	
	@Test
	public void main() {
		int[] arr = {7,3,2,1,1,7,-6,-1,7};
		int arm = 7;
		//8888经典方法->传入一个数组arr和长度arm,返回和为arm的最长子数组的长度
		int len = getMaxLong(arr,arm);
		System.out.println(len);
	}

	//经典方法-->传入一个数组arr和长度arm,返回和为arm的最长子数组的长度
	private int getMaxLong(int[] arr, int arm) {
		if(arr == null || arr.length == 0){
			return 0;
		}
		//创建一个Treemap的双列集合
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(0, -1);	//在下标为-1是sum为0
		//初始化累加和为0
		int sum = 0;
		//最长的长度,如果没有的话返回0
		int len = 0;
		//需要遍历整个数组
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];//累加
			//将累加和添加到map中(如果不包含就添加进去,如果包含就保持原值,不添加)
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum-arm)) {	//判断sum-arm是否包含在map中
				int curlen = i - map.get(sum-arm);
				len = Math.max(curlen, len);//获取最长的长度
			}
		}
		return len;
	}
}
