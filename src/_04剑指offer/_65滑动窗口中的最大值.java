package _04剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * 题目:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 	 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 		那么一共存在6个滑动窗口，他们的最大值分别为  {4,4,6,6,6,5}； 
 * 		针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 
 * 		{[2,3,4],2,6,2,5,1}， 
 * 		{2,[3,4,2],6,2,5,1}， 
 * 		{2,3,[4,2,6],2,5,1}， 
 * 		{2,3,4,[2,6,2],5,1}， 
 * 		{2,3,4,2,[6,2,5],1}， 
 * 		{2,3,4,2,6,[2,5,1]}
 */
public class _65滑动窗口中的最大值 {
	

	public static void main(String[] args) {
		System.out.println("加加加");
	}
	public ArrayList<Integer> maxInWindows(int [] arr, int size){
		//BaseCase
		//创建返回的结果集合
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (arr==null||size<=0||size>arr.length) {
			return list;
		}
		//创建一个辅助容器双端列表
		LinkedList<Integer> queue = new LinkedList<Integer>();  //队列中可以只存下标,它的值可以根据arr[]获取到
		for (int i = 0; i < arr.length; i++) {
			//队列中添加
			while (!queue.isEmpty()&&arr[queue.getFirst()]<=arr[i]) {
				//如果对列不为空,且对列头部的元素比当前元素小则删除对列头部元素
				queue.pollFirst();
			}
			//否则就将元素从队列的头部添加(此处指的是元素的下标)
			queue.addFirst(i);
			
			//此处i-w为窗口的尾部位置
			if (i-size == queue.getLast()) {
				queue.pollLast();
			}
			if (i+1-size >= 0) {
				list.add(arr[queue.getLast()]);
			}
		}
		return list;
    }
}
