package _04剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/*
 *题目: 输入n个整数，找出其中最小的K个数。
 *		例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *思路:升序排序后,返回前k个数
 */
public class _30最小的K个数 {

	@Test
	public void main() {
		int[] input = {4,5,1,6,2,7,3,8};
		ArrayList<Integer> list = GetLeastNumbers_Solution(input, 10);
		System.out.println(list);
	}
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>(); //创建一个用于返回 链表
		//basecase
		if (input == null || input.length == 0 || k <= 0) {
			return list;
		}
		//默认升序排列
		Arrays.sort(input); 
		int tem = 0;
		//当输入k大于所有元素个数时,全部返回******
		while(tem < k && tem < input.length){ 
			list.add(input[tem]);
			tem++;
		}
		return list;
    }
}
