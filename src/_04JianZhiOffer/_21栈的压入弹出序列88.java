package _04JianZhiOffer;

import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��(����ѹ��ջ���������־�����ȡ�)
 * 		��������1,2,3,4,5��ĳջ��ѹ��˳��
 * 		      ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * 		         ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 * 
 * ˼·:ģ��һ����ʵ��ѹջ��ջ,����һ��ջ�ṹ(stack),����ѹջ��˳������ѹջ,����һ��ָ���ʼָ���ջ����ĵ�һ��λ��.
 * 		ÿ��ѹջ���ж�ջ���Ƿ���ָ��ָ��ĳ�ջ��������ͬ,�����ͬ��ջ,ָ�������ƶ�,�ڴ��ж�.
 * 		ֱ��������������ջ�����Ԫ��,���������ָ��û��ָ������β��˵��ʧ��
 */
public class _21ջ��ѹ�뵯������88 {
	
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
		int index = 0;//ָ���ջ�����ָ��
		for (int i = 0; i < popA.length; i++) {
			stack.push(pushA[i]); //ѹ��һ����
			//�ж��Ƿ����ջͷ��ͬ
			while(!stack.isEmpty() && stack.peek() == popA[index]){
				stack.pop();
				index++;
			}
		}
		return index == popA.length;
	}
}
