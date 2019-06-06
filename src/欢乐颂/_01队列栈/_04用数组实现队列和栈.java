package 欢乐颂._01队列栈;


/**
 * 用数组结构实现大小固定的队列和栈
 * 栈(先进后出)利用一个index指针,当加入元素时添加到index指向的位置,并且index++
 * 		当去除一个元素时,去除index--最所对应的位置,并且index减一  (利用--index)
 * 
 * 队列(先进先出),利用到三个指针,一个start(头部取值,从头部取值,取出后start++,size--),
 * 		一个end(尾部追加代表从此处添加元素并end++,size++),一个size代表队列的元素个数
 */
public class _04用数组实现队列和栈 {

	public static void main(String[] args) {
		Mystack my = new Mystack(5);
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
		System.out.println(pop1+""+pop2+""+pop3+""+pop4+""+pop5);
		System.out.println("----------------------------------------");
		MyQueue queue = new MyQueue(5);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		int po1 = queue.pop();
		int po2 = queue.pop();
		int po3 = queue.pop();
		int po4 = queue.pop();
		int po6 = queue.pop();
//		int po5 = queue.peek();
//		int po7 = queue.pop();
		System.out.println(po1+""+po2+""+po3+""+po4+""+po6);
	}
}

class Mystack {
	int [] stack;
	int index = 0;
	//因为是固定长度,因此创建时要规定好长度
	public Mystack(int len){
		stack = new int[len];
	}

	//压栈
	public void push(int cur){
		if (index > stack.length) {
			throw new RuntimeException("栈内存已满");
		}
		stack[index++] = cur;
	}
	
	//删除并返回栈顶
	public int pop(){
		if (index <= 0) {
			throw new RuntimeException("栈中不存在元素");
		}
		return stack[--index];
	}
	
	//返回栈顶元素
	public int peek(){
		if (index <= 0) {
			throw new RuntimeException("栈中不存在元素");
		}
		int tem = stack[--index];
		index++;
		return tem;
	}
}

class MyQueue {
	int [] queue;
	int start = 0;	//指向队头.在此处拿元素
	int end = 0;	//指向队尾,在此处添加元素
	int size = 0;	//代表队列的大小
	
	//因为是固定长度,因此创建时要规定好长度
	public MyQueue(int len){
		queue = new int[len];
	}
	
	//向队列尾部加入数据
	public void push(int cur){
		if (size >= queue.length) {
			throw new RuntimeException("队列内存已满");
		}
		queue[end++] = cur;
		size++;
		end = (end==queue.length ? 0:end); //如果到了顶部就将他重新指向0位置
	}

	public int peek(){
		if (size == 0) {
			throw new RuntimeException("队列中无元素");
		}
		return queue[start];
	}
	
	public int pop(){
		if (size == 0) {
			throw new RuntimeException("队列中无元素");
		}
		int tem = queue[start++];
		size--;
		start = (start==queue.length ? 0:start);
		return tem;
	}
}
