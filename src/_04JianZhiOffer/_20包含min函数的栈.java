package _04JianZhiOffer;
import java.util.Stack;

import org.junit.Test;
/*
 * ��Ŀ:����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1����
 * ˼·:��������ջ,һ��stack,һ��minstack
 * 		��stack������ջ����
 * 		��minstack����Զά��ջ��������Ԫ������С��
 * 		push����--stack����push
 * 				-minstack,������û��Ԫ��������push.�����Ԫ��,����ջ���Ƚ�,push�Ƚϵ�С���Ǹ����
 * 		pop��ȡջ�� --stack��ջ��Ԫ�ط���
 * 		topɾ��----stack��minstack�ֱ�ɾ��ջ��Ԫ��
 * 		min-------minstack��ջ��Ԫ�ط���
 */
public class _20����min������ջ {

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
	    
		//ɾ��
	    public void pop() {
	    	minstack.pop();
	        stack.pop();
	    }
	    //����ջ��
	    public int top() {
			return stack.peek();
	    }
	    
	    public int min() {
			return minstack.peek();
	    }
	}
}
