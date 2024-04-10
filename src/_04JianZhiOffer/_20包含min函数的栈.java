package _04JianZhiOffer;
import java.util.Stack;

import org.junit.Test;
/*
 * 题目:定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * 思路:创建两个栈,一个stack,一个minstack
 * 		在stack中正常栈操作
 * 		在minstack中永远维持栈顶是所有元素中最小的
 * 		push操作--stack正常push
 * 				-minstack,若里面没有元素则正常push.如果有元素,则与栈顶比较,push比较的小的那个结果
 * 		pop读取栈顶 --stack的栈顶元素返回
 * 		top删除----stack和minstack分别删除栈顶元素
 * 		min-------minstack的栈顶元素返回
 */
public class _20包含min函数的栈 {

	@Test
	public void main() {

		MyStack stack = new MyStack();
		stack.push(3);
		System.out.println(stack.min());
		stack.push(4);
		System.out.println(stack.min());
		stack.push(2);
		System.out.println(stack.min());
		
	}
	
	class MyStack{
		
		Stack<Integer> stack = null;
		Stack<Integer> minstack = null;
		public MyStack(){
			stack = new Stack<Integer>();
			minstack = new Stack<Integer>();
		}
		
		public void push(int node) {
			stack.push(node);
			if (minstack.size() == 0) {
				minstack.push(node);
			}else {
				int min = Math.min(minstack.peek(), node);
				minstack.push(min);
			}
	    }
	    
		//删除
	    public void pop() {
	    	minstack.pop();
	        stack.pop();
	    }
	    //返回栈顶
	    public int top() {
			return stack.peek();
	    }
	    
	    public int min() {
			return minstack.peek();
	    }
	}
}
