package _07LeetCode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * ����:https://leetcode.cn/problems/implement-stack-using-queues/description/
 *  �ö���ʵ��ջ
 *
 *  ˼·1:ʹ������������ʵ��һ��ջ�Ĺ���
 *  �����ʹ��ջ��ʵ�ֶ��в�ͬ����Ϊջ�Ľṹ��FILO,�������ܹ�ͨ��ʹ������ջ��ʵ�ַ�ת�Ӷ��ﵽ���е�Ч����
 *  �����������FIFO����˼�ʹʹ�õ��������У����������е�����ȥʵ����Ԫ�ص�˳��û�иı䡣
 *  �������ֻ��Ҫͨ��һ�����о��ܹ�ʵ��ջ�Ĺ��ܡ����������Q��
 *  employ->���ض��е�employ��Ϣ��
 *  push-> ֱ�ӽ�Ԫ�ز鵽����Q�С�
 *  pop-> ��ȡ��ǰ���е�size(),�Զ���Qִ�� size()-1 ��pop����������pop���Ԫ��push������β��������ԭ����β��Ԫ�ؾ͵��˵�һλ��ֱ��ִ�У�pop
 *  peek-> ��ȡ��ǰ���е�size(),�Զ���Qִ�� size()-1 ��pop����������pop���Ԫ��push������β��������ԭ����β��Ԫ�ؾ͵��˵�һλ��
 *          ֱ��ִ�У�peek��ִ������ٽ���ŵ���β��
 *
 */

public class _202ջ_����_�ö���ʵ��ջ225 {


    @Test
    public void main() {
        System.out.println("��ʼ");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // ���� 2
        System.out.println(myStack.pop()); // ���� 2
        System.out.println(myStack.empty()); // ���� False
    }

    class MyStack {

        private LinkedList<Integer> q;
        public MyStack() {
            q = new LinkedList<Integer>();
        }

        public void push(int x) {
            q.add(x);
        }

        public int pop() {
            int size = q.size();
            while (size > 1) {
                q.add(q.pop());
                size--;
            }
            return q.pop();
        }

        public int top() {
            int size = q.size();
            while (size > 1) {
                q.add(q.pop());
                size--;
            }
            int result =  q.pop();
            q.add(result);
            return result;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }


}