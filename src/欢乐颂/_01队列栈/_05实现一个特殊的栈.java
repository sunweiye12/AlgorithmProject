package 欢乐颂._01队列栈;

import java.util.Stack;

/**
 * 	实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
	回栈中最小元素的操作。
【要求】
	1．pop、push、getMin操作的时间复杂度都是O(1)。*****
	2．设计的栈类型可以使用现成的栈结构。
 * 
 * 思路:既然都是O(1)那就不能用排序算法利用,可以利用两个栈来实现,一个数据栈,一个min栈.数据栈一切都一样
 * 		二min栈每次push的时候都和栈顶比较,如果比栈顶小泽压入本身,否则压入栈顶元素
 */
public class _05实现一个特殊的栈 {

	public static void main(String[] args) {
		MyStack1 my = new MyStack1();
		my.push(1);
		my.push(6);
		my.push(-2);
		my.push(4);
		my.push(0);
		my.push(1);
		my.push(-8);
		System.out.println(my.getMin());
	}
}

class MyStack1{
	
	private Stack<Integer> DataStack;
	private Stack<Integer> MinStack;
	
	public MyStack1(){
		DataStack = new Stack<Integer>();
		MinStack = new Stack<Integer>();
	}
	
	public void push(int cur){
		if (DataStack.isEmpty()) {
			DataStack.push(cur);
			MinStack.push(cur);
		}
		DataStack.push(cur);
		//和栈顶比较哪个最小,哪个最小压入哪个****(min栈中不是存放的是一个元素)
		Integer min = MinStack.peek();
		cur = cur < min? cur:min;
		MinStack.push(cur);
	}
	
	public int peek(){
		return DataStack.peek();
	}
	
	public int pop(){
		MinStack.pop();
		return DataStack.pop();
	}
	
	public int getMin(){
		return MinStack.peek();
	}
}
