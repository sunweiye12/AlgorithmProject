package _04JianZhiOffer;

import java.util.Stack;

import org.junit.Test;

/*
 * 题目:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。(假设压入栈的所有数字均不相等。)
 * 		例如序列1,2,3,4,5是某栈的压入顺序，
 * 		      序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 		         但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 
 * 思路:模拟一个真实的压栈出栈,创建一个栈结构(stack),按着压栈的顺序依次压栈,设置一个指针初始指向出栈数组的第一个位置.
 * 		每次压栈都判断栈顶是否与指针指向的出栈数组数相同,如果相同则弹栈,指针向右移动,在此判断.
 * 		直到不相等则据需往栈中添加元素,如果结束后指针没有指向数组尾部说明失败
 */
public class _21栈的压入弹出序列88 {
	
	@Test
	public void main() {
		int[] pushA = {1,2,3,4,5};
		int[] popA = {4,5,3,2,1};
//		int[] popA = {4,3,5,1,2};
		boolean b = IsPopOrder(pushA, popA);
		System.out.println(b);
	}
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		//basecase
		if (pushA.length != popA.length) {return false;}
		if (pushA.length==0 && popA.length==0) {return true;}
		Stack<Integer> stack = new  Stack<Integer>();
		int index = 0;//指向出栈数组的指针
		for (int i = 0; i < popA.length; i++) {
			stack.push(pushA[i]); //压入一个数
			//判断是否与出栈头相同
			while(!stack.isEmpty() && stack.peek() == popA[index]){
				stack.pop();
				index++;
			}
		}
		return index == popA.length;
	}
}
