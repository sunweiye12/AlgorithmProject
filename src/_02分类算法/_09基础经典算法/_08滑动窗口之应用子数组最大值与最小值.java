package _02分类算法._09基础经典算法;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 题目描述:最大值减去最小值小于或等于num的子数组数量
 *   给定数组arr和整数num, 共返回有多少个子数组满足如下情况:
 *   max(arr[i...j])-min(arr[i...j]) <= num
 *   max(arr[i...j])表示子数组arr[i...j]中的最大值,
 *   min(arr[i...j])表示子数组arr[i...j]中的最小值,
 *   
 *   要求:如果数组的长度为N,请事先时间复杂度为N的算法
 * 
 * 思路:
 * 暴力解发:时间复杂度为O(N^3)
 * 	通过冒泡算法或则选择排序算法可以将整个数组的所有子数组得出
 * 	利用排序对每个子数组得出最大值和最小值(或者不用排序只得到最大值和最小值通过利用Integer.min等实现O(n))
 * 	然后根据需求来判断计数器是否加1
 * 
 * 利用滑动窗口来解:优良解时间复杂度为O(N)  --> 双端队列,从小到大
 * 	假设在max(arr[i...j])-min(arr[i...j]) <= num称之为达标
 *  i到j的位置达标,则i到j的子串一定都达标(即i到j内部不用判断都达标)
 *  i到j的位置不达标,则包含i到j的子串一定都不达标(即i到j外部不用判断都不达标)
 *  利用滑动窗口(窗口的左边为L 右面为R)起初都在下标为0的位置R不断向右走,假如说
 *  L到R的位置值都达标当r指向p位置时第一次不达标,于是可以得出以0下标开头的子串达标的
 *  个数为p,然后L向右移动一个依次判断1小白哦位置来头达标的个数,依此循环,知道L走完数组.就判断出了
 *  以每一个元素开头的子串对应的达标个数,都加起来的话就得到了result
 *  分析:因为整个过程就是整个窗口划过数组的过程,因此时间复杂度为O(n)
 *  
 * @author Administrator
 */
public class _08滑动窗口之应用子数组最大值与最小值 {
	
	@Test
	public void main() {
		int[] arr = {3,5,2,6};	//数组
		int num = 2; 					//比较值的大小
		int i = getNum(arr,num);
		System.out.println(i);
		
	}
	
	
	//给定一个数组,返回子数组符合条件的个数
	//条件:子数组的最大值减去最小值小于等于num
	private int getNum(int[] arr, int num) {
		if (arr == null || arr.length ==0) {
			return 0;
		}
		//设置返回值
		int result = 0;
		//设置窗口的左右边界
		int L = 0;	//窗口左边界
		int R = 0;	//窗口右边界
		//创建两个个存放最大值和最小值的双端队列///(--->都是尾部加入头部取出)
		LinkedList<Integer> maxNum = new LinkedList<Integer>();
		LinkedList<Integer> minNum = new LinkedList<Integer>();
		//L从第一个位置到倒数第一个位置(每一次循环得到当前位置开头的子串中有多少达标)
		while(L < arr.length){
			//窗口右端开始向右移动双端队列开始加元素(直到R走到了最右侧或者碰到了第一个不符合条件的子串)
			while(R < arr.length){
				//最大值栈的添加策略
				while(!maxNum.isEmpty() && arr[maxNum.peekLast()] <= arr[R]){
					maxNum.pollLast();
				}
				maxNum.addLast(R);
				while(!minNum.isEmpty() && arr[minNum.peekLast()] >= arr[R]){
					minNum.pollLast();
				}
				minNum.addLast(R);
				if (arr[maxNum.peekFirst()]-arr[minNum.peekFirst()] > num) {
					break;
				}
				//R向右移动一步
				R++;
			}
			//得到当前L位置开头的子串中符合条件的
			result += R - L;
			
			//窗口左移
			if (maxNum.peekFirst()==L) {
				maxNum.pollFirst();
			}
			if (minNum.peekFirst()==L) {
				minNum.pollFirst();
			}
			L++;
		}
		return result;
	}
	


}
