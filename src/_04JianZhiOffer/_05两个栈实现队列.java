package _04JianZhiOffer;

import java.util.Stack;

import org.junit.Test;

/*
 * ��Ŀ:������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ˼·:��������ջ(stack/help),�����Ԫ�ص�ʱ����ӵ�stackջ��
 * 		������Ԫ�ص�ʱ��,���stackԪ�ض���һ��,�����Ԫ�ض�����helpջ��,ֱ��ʣ�����һ��Ԫ��,��������
 * 		,Ȼ���ڽ�hlepջ�е�Ԫ�طŻ�stackջ��
 */
public class _05����ջʵ�ֶ��� {

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
	    
	    public void push(int node) {	//ÿ�����ջ���ŵ�stack��
	    	stack.push(node);
	    }
	    
	    public int pop() {
	    	if (stack.isEmpty()) {
				throw new RuntimeException("������û��Ԫ��");
			}
	    	
	    	while(stack.size()!=1){ //��stack�е�Ԫ�ص���help��ֻ��һ��
	    		help.push(stack.pop());
	    	}
	    	int result = stack.pop();
	    	while(help.size()!=0){	//��help�е�Ԫ��ȫ����stack��
	    		stack.push(help.pop());
	    	}
	    	return result;
	    }
	    
	    public int count(){
	    	return stack.size();
	    }
	    
	}
}
