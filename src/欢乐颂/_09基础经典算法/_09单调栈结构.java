package 欢乐颂._09基础经典算法;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/**
 * 单调栈用来解决的原始问题是:在一个无序的数组中快速找到每一个数左右两侧第一个比本身大(小)的数;
 * 例如: 数组{2,7,4,3,9}  元素4左面第一个比他大的是7,右面比他大的是9
 * 思路: 应上面的题意,设计一个栈结构(先进后出),栈底到栈顶依次维持元素*从大到小*
 * 		当加入第一个元素的时候放入栈底,每一次添加元素都与栈顶作比较,
	 * 		如果小于栈顶元素.即不违背栈底到栈顶依次元素从大到小的原则,就将此元素压栈.
	 * 		如果发现此元素a大于栈顶元素v,则开始记录,弹出栈顶元素v,v的左侧比他大的是其下面的元素,右侧比他大元素为a
	 * 		循环上面的case,直到遇到比a大的元素或者栈空了,将a推入栈中
 * 			如果遇到栈顶元素与加入的元素相同大小,则将此元素下表和中那定元素的下表一链表的形式存放到一个里面
 * 		当添加完所有元素以后,开始从栈顶想外弹出元素,则栈顶元素弹出是左面比他大的值为下面的元素(如果是最后一个元素则为空)
 * 		右面比他大的元素为空,
 */
public class _09单调栈结构 {
	
	@Test
	public void main() {
		int[] arr = {2,7,4,3,4,9};
		
		//打印每个元素左面和右面第一个比他大数
		Monotstack(arr);
	}

	private void Monotstack(int[] arr) {
		
		//创建一个栈结构 (里面维护的是一个链表结构,相同的元素可以链表保存)
		Stack<LinkedList<Integer>> stack = new Stack<LinkedList<Integer>>();
		//将数组中的元素添加倒栈结构
		for (int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty()&&arr[stack.peek().getLast()] < arr[i]){
				//一直向外弹
				LinkedList<Integer> list = stack.pop();//得到栈顶下表的链表
				while(!list.isEmpty()) {
					int last = arr[list.pollLast()];
					int zuo = stack.isEmpty() ? 10000: arr[stack.peek().getLast()];
					int you = arr[i];
 					System.out.println("元素"+last+"--> 左:"+ zuo +"右:"+ you);
				}
			}
			
			if (!stack.isEmpty()&&arr[stack.peek().getLast()] == arr[i]) {
				//相同元素
				stack.peek().addLast(i);
			} else {
				//直接压栈
				LinkedList<Integer> linked = new LinkedList<Integer>();
				linked.add(i);
				stack.push(linked);
			}
		}
		
		while (!stack.isEmpty()) {
			LinkedList<Integer> list = stack.pop();//得到栈顶下表的链表
			while(!list.isEmpty()) {
				int last = arr[list.pollLast()];
				int zuo = stack.isEmpty() ? 10000: arr[stack.peek().getLast()];
				int you = 10000;
					System.out.println("元素"+last+"--> 左:"+ zuo +"右:"+ you);
			}
		}
	}
}
