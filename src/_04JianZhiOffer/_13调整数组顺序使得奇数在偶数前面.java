package _04JianZhiOffer;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
 * 题目:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	  使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
	  并保证奇数和奇数，偶数和偶数之间的相对位置不变

      思路:1.创建一个集合arraylist,用于盛放排序后的数组,利用merge原理
      2.遍历浪遍数组arr,第一遍将所有的的奇数放进去,第二遍吧说有的偶数放进去
      3.然后在将arraylist中元素都添加到arr数组中
 */
public class _13调整数组顺序使得奇数在偶数前面 {

	@Test
	public void main() {
		int[] arr = {1,3,9,4,2,8,7,1,4,11};
		reOrderArray(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void reOrderArray(int [] array) {
        List<Integer> list = new LinkedList<Integer>();
        
        for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) { //如果是奇数
				list.add(array[i]);
			}
		}
        for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) { //如果是偶数数
				list.add(array[i]);
			}
		}
        for (int i = 0; i < array.length; i++) {
        	array[i] = list.get(i);
		}
        
    }
}
