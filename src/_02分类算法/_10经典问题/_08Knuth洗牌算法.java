package _02分类算法._10经典问题;

import org.junit.Test;

/*
 * 题目:给你一个int[]数组,然后随机打乱,返回新的数组
 * 		注:提供一个公平的算法,要求每一中排列出现的概率相同
 * 
 * 思路:此处利用的是,Knuth洗牌算法,他能保障每一个位置出现每一个数的概率相同,也就是每一个个数,落到任意位置的概率相同
 */
public class _08Knuth洗牌算法 {

	@Test
	public void main() {
		int[] arr = {1,2,3,4,5};
		int[] arr1 = partion(arr);
		for (int i : arr1) {
			System.out.print(i +" ");
		}
	}

	//随机洗牌
	private int[] partion(int[] arr) {

		for (int i = arr.length-1; i >= 0; i--) {
			swap(arr,i,(int)(Math.random() * (i + 1)));
		}
		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}

}
