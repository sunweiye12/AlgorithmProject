package 欢乐颂._10经典问题;

import org.junit.Test;

/*
 * 题目:给定你一个int类型的数组(***全为正数**),和一个arm值.返回子数组中所有数和为arm的最长的子数组的长度.
 * 例如:int arr = {7,3,2,1,1,7,7,7}  int arm = 7				
 * 因为和为7的最长子数组为{3,2,1,1},则返回的 4
 * 
 * 暴力解思路:求出所有子数组,分别计算每个子数组的和时是否为arm,然后在保留一个最大长度进行返回
 * 
 * 经典思路:在一个数组中.我们先解决以某一个数结尾的子数组中累加和为arm的最长子数组,
 * 		假设求第100个数结尾最长子数组,和为arm等于80,假如知道这100个数的和为200,那从第一个数开始累加,当加到一个数时和为120,
 * 		则下一个数到第一百个数的和就是80;且这个长度是最长的;
 * 		根据此思路可以设计程序,上面给出了arr数组和arm值.
 * 		你自己定义一个sum来记录从0位置开始的累加和.
 * 		定义一个map双列集合.key为每次累加后的sum, value为第一次出现sum所对应的数组下标
 * 		每次累加后将数据添加到map集合中,然后来判断sum-arm(即上面的1200)是否在集和Map中存在key,
 * 		如果存在则表明从它的下一个数到当前下标的数累加和为arm
 * 
 * 升级思路:滑动窗口问题:设置一个滑动窗口,从数组的头部开始进图元素,当所有元素之和小于aim时,窗口进元素,当等于aim时记录长度
 * 		当大于aim时,窗口出元素,直到窗口右侧到达数组右边界  ( 时间复杂度为O(n) 空间复杂度为O(1) )
 * 	(因为都是正数,所以只要扩元素sum一定增加,只要减元素,sum一定减小,所以可以利用双指针->滑动窗口来解决此问题)
 */
public class _02累加和为指定值的最长子数组长度_2 {

	@Test
	public void main() {
		int[] arr = { 7, 3, 2, 1, 1, 7, 7, 7 };
		int arm = 7;
		int len = getMaxLong(arr, arm);
		System.out.println(len);
	}

	// 滑动窗口解法
	private int getMaxLong(int[] arr, int arm) {
		if (arr == null || arr.length == 0 || arm <= 0) {
			return 0;
		}
		// 左右边界初始位置
		int L = 0;
		int R = 0;
		// 初始的窗口元素和
		int sum = arr[0];
		// 初始长度
		int len = 0;
		while (R < arr.length) {
			if (sum == arm) {
				// 相等的时候记录长度 后左边界移动(进一个元素)
				len = Math.max(len, R - L + 1);
				sum -= arr[L++];
			} else if (sum > arm) {
				// sum > arm的时候窗口出元素
				sum -= arr[L++];
			} else {
				// sum < arm的时候窗口进元素
				R++;
				if (R == arr.length) {
					break;
				}
				sum += arr[R]; // 如果R=arr.length时 , arr[R]就会发生越界(因此前面要判断一下)
			}
		}
		return len;
	}
}
