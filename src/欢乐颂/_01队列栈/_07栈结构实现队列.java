package 欢乐颂._01队列栈;

import java.util.Stack;

/**
 * 	栈实现队列   的话也是需要两个栈才能够实现一个对列,一个push堆.一个pop堆
 * 	存储时将数据存放到push栈中,在取的时候将push堆中的数据一次取出倒入pop堆
 * 	完成后返回pop堆堆顶的元素,完事后在将pop栈中的元素都导入push栈
 * 	(注意:1.当pop堆中有元素是不能想里面倒元素  2.每次push堆想help堆中到元素一定要倒完)
 * 
 *
 */
public class _07栈结构实现队列 {
	public static void main(String[] args) {
		MyQueue2 my = new MyQueue2();
		my.push(1);
		my.push(2);
		my.push(3);
		my.push(4);
		my.push(5);
		int pop1 = my.pop();
		int pop2 = my.pop();
		int pop3 = my.pop();
		int pop4 = my.pop();
		int pop5 = my.peek();
		int pop6 = my.pop();
//		int pop7 = my.pop();
		System.out.println(pop1+" "+pop2+" "+pop3+" "+pop4+" "+pop5);
	}
}

class MyQueue2{
	Stack<Integer> pushStack;	//用于存储元素
	Stack<Integer> popStack;	//在取元素的时候将数据导入其中
	
	public MyQueue2(){
		pushStack = new Stack<Integer>();
		popStack = new Stack<Integer>();
	}
	
	//队列中添加元素
	public void push(int cur){
		pushStack.push(cur);
	}
	
	//队列中删除元素
	public int pop(){
		if (pushStack.isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		swap(); //将push栈中的元素倒入pop栈
		int tem = popStack.pop();	//取出pop栈的栈顶元素
		swap(); //将pop栈中的元素再倒回push栈
		return tem;
	}
	
	//去除队列头部元素
	public int peek(){
		if (pushStack.isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		swap(); //将push栈中的元素倒入pop栈
		int tem = popStack.peek();	//取出pop栈的栈顶元素
		swap(); //将pop栈中的元素再倒回push栈
		return tem;
	}
	
	//将数据从一个栈导入另一个栈(从一个非空栈导入另一个空斩)
	public void swap(){	
		if (pushStack.isEmpty() && popStack.isEmpty()) {
			return;
		} else if (pushStack.isEmpty() && !popStack.isEmpty()) {
			while (!popStack.isEmpty()){
				pushStack.push(popStack.pop());
			}
		} else if(!pushStack.isEmpty() && popStack.isEmpty()) {
			while (!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
		}
	}
}
