package 欢乐颂._08暴力递归_动态规划;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题意:给定你一个字符串,返回其中最长不重复子串的个数
 * 
 *  例如: 4,5,6,7,4,3,6,8  --> 最长不重复子串为5,6,7,4,3或7,4,3,6,8-->长度为5
 *  
 *  思路:利用双指针和set集合来实现,分别计算以每一个字符串结尾的不重复子串的大小
 */
public class _15最长不重复子串 {

	@Test
	public void main() {
		int[] arr = {1,2,3,3,4,5,2,5,6};
		int size = partion(arr);
		System.out.println(size);
	}

	//返回最长不重复子串的长度
	private int partion(int[] arr) {
		//basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//至少有一个元素
		int size = 1;
		//创建判断去重的set集合
		Set<Integer> set = new LinkedHashSet<Integer>();
		//定义双指针
		int left = 0;
		int right = 0;
		while(left != arr.length){
			//只要有你指针没有越界,并且set中不包含arr[right]元素
			while(right < arr.length && !set.contains(arr[right])){
				set.add(arr[right]);
				right++;
			}
			//说明到达了最右侧,或者right所指向的元素存在重复
			size = Math.max(size, right-left);
			System.out.println(set.toString());
			//去除掉最前面的元素重新判断
			set.remove(arr[left++]);
		}
		return size;
	}
}
