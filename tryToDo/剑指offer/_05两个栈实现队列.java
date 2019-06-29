package 剑指offer;

import java.util.Stack;

import org.junit.Test;

/*
 * 题目:用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路:设置两个栈(stack/help),当添加元素的时候都添加到stack栈中
 * 		当弹出元素的时候,如果stack元素多余一个,将多的元素都放入help栈中,直到剩下最后一个元素,弹出返回
 * 		,然后在将hlep栈中的元素放回stack栈中
 */
public class _05两个栈实现队列 {

	@Test
	public void main() {
		Solution su = new Solution();
		su.push(1);
		su.push(2);
		su.push(3);
		su.push(4);
		System.out.println(su.pop());
		System.out.println(su.pop());
		System.out.println(su.pop());
		System.out.println(su.pop());
	}
	
	public class Solution {
	    Stack<Integer> stack = new Stack<Integer>();
	    Stack<Integer> help = new Stack<Integer>();
	    
	    public void push(int node) {	//每次添加栈都放到stack中
	    	stack.push(node);
	    }
	    
	    public int pop() {
	    	if (stack.isEmpty()) {
				throw new RuntimeException("队列中没有元素");
			}
	    	
	    	while(stack.size()!=1){ //将stack中的元素倒入help中只留一个
	    		help.push(stack.pop());
	    	}
	    	int result = stack.pop();
	    	while(help.size()!=0){	//将help中的元素全倒入stack中
	    		stack.push(help.pop());
	    	}
	    	return result;
	    }
	}
}
