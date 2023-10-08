package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 		如果是则输出Yes,否则输出No。
 * 		注:假设输入的数组的任意两个数字都互不相同。
 * 
 * 思路:对于搜索二叉树的后序遍历,最后一个节点为根节点,其大于所有的左孩子,小于所有右孩子
 * 		可以将后序遍历的最后一个节点去掉,则剩下的部分可以利用头结点分成左右两部分,左右两部分满足左部分都小于root,右部分都大于root
 * 		然后依次递归
 */
public class _23二叉搜索树的后序遍历88 {

	@Test
	public void main() {
		int[] arr = {1,4,3,6,8,7,9}; //给定一个二叉树后序遍历的结果一个
		boolean isBST = partion(arr,0,arr.length-1);
		System.out.println(isBST);
	}

	private boolean partion(int[] arr, int start, int end) {
		//basecase(只有一个节点 的话也是平衡二叉树)
		if (start >= end) {
			return true;
		}
		int index = start; //index用于记录左右两个节点的位置
		for(index = start;index < end ;index++){
			if (arr[index] > arr[end]) { //当找到第一个比arr[end]大的数结束,意味这index指向右节点的第一个位置
				break;
			}
		}

		for (int i = index; i < end; i++) { //接下来所有的右孩子应该都大于arr[end],否则不是BST
			if (arr[i] <= arr[end]) {
				return false;
			}
		}
		//然后判断分割后的这两个是否都为BST
		return partion(arr, start, index-1) && partion(arr, index, end-1);
	}
}
