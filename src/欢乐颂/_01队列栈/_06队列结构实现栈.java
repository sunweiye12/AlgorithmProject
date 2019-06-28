package 欢乐颂._01队列栈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
 * 	队列是先入先出结构,栈是先入后出节后
 * 利用队列来实现栈结构需要利用两个队列,一个data队列,一个help队列
 * 存数据时正常那个将data队列中push(假设有n个元素),然而在取的队列只能取到
 * 最先放进去的元素,而栈的功能是取到刚放进去的元素,因此,将此事队列中的n-1个数取出放到help队列中
 * 然后再将data队列中的最后一个数据返回,一切完成后,将help和data对列的索引交换
 * 
 *
 */
public class _06队列结构实现栈 {

	public static void main(String[] args) {
		MyQueue1 qu = new MyQueue1();
		qu.push(1);
		qu.push(2);
		qu.push(3);
		qu.push(4);
		qu.push(5);
		int pop = qu.pop();
		int pop2 = qu.pop();
		int pop3 = qu.pop();
		int pop4 = qu.pop();
		int pop5 = qu.pop();
		System.out.println(pop+" "+pop2+" "+pop3+" "+pop4+" "+pop5);
	}
}

class MyQueue1{
	Queue<Integer> dataQueue;
	Queue<Integer> helpQueue;
	public MyQueue1(){
		dataQueue = new LinkedList<Integer>();
		helpQueue = new LinkedList<Integer>();
	}
	
	public void push(int cur){
		dataQueue.add(cur);
	}
	
	public int pop(){
		if (dataQueue.isEmpty()) {
			throw new RuntimeException("队列是空的");
		}
		while (dataQueue.size() != 1) {
			helpQueue.add(dataQueue.poll());
		}
		int tem = dataQueue.poll();
		swap();
		return tem;
	}
	
	public int peek(){
		if (dataQueue.isEmpty()) {
			throw new RuntimeException("队列是空的");
		}
		while (dataQueue.size() != 1) {
			helpQueue.add(dataQueue.poll());
		}
		int tem = dataQueue.poll();
		helpQueue.add(tem);
		swap();
		return tem;
	}
	
	private void swap() {
		Queue<Integer> tem = new DelayQueue();
		tem = dataQueue;
		dataQueue = helpQueue;
		helpQueue = tem;
	}
}