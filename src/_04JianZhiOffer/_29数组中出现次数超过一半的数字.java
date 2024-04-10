package _04JianZhiOffer;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	  例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
	  由于数字2在数组中出现了5次，超过数组长度的一半，
	  因此输出2。如果不存在则输出0。
	
	思路:通过HashMap来进行词频统计,然后找到凑数最多的那个元素(只遍历一遍),判断他的次数是不是大于数组长度的一半.
		(时间复杂度=O(N)+O(n),N是样本量,n是无重复的元素的个数)
 */
public class _29数组中出现次数超过一半的数字 {
	
	@Test
	public void main() {
		
		int[] arr = {1,2,3,2,2,2,5,4,2};
		int num = MoreThanHalfNum_Solution(arr);
		System.out.println(num);
	}
	
	public int MoreThanHalfNum_Solution(int [] arr) {
		//basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//创建一个hashmap用于做词频统计,其中key为数值,value为此值出现的次数
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) { //如果之前统计过,则将此处加一
				int tem = map.get(arr[i]);
				map.put(arr[i], tem+1);
			} else{
				map.put(arr[i], 1);
			}
		}
		//将hashmap中的键值对按照value来排序(得到最大的value.看看是否大于数组长度的一半)
		Set<Integer> keySet = map.keySet();
		int retMaxVal = arr[0]; //转入第一个元素
		for (Integer temKey : keySet) {
			retMaxVal = map.get(retMaxVal) > map.get(temKey) ? retMaxVal : temKey;
		}
		return map.get(retMaxVal) > arr.length>>1 ? retMaxVal : 0;
    }
}
