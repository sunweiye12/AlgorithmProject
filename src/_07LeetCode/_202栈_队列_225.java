package _07LeetCode;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Stack;

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

public class _202ջ_����_225 {


    @Test
    public void main() {
        System.out.println("��ʼ");

    }

    class MyStack {

        private PriorityQueue<Integer> q;
        public MyStack() {
            q = new PriorityQueue<>();
        }

        public void push(int x) {
            q.add(x);
        }

        public int pop() {
            int size = q.size();
            while (size > 1) {
                q.add(q.poll());
                size--;
            }
            return q.poll();
        }

        public int peek() {
            int size = q.size();
            while (size > 1) {
                q.add(q.poll());
                size--;
            }
            int result =  q.poll();
            q.add(result);
            return result;
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }


}