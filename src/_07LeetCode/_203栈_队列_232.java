package _07LeetCode;
import org.junit.Test;
import java.util.Stack;

/**
 * ����:https://leetcode.cn/problems/implement-queue-using-stacks/
 *  ��ջʵ�ֶ���
 *
 *  ˼·1:ʹ������ջ��ʵ��һ������
 *  ����ջ������,һ��ջ����д������ input_s ,����һ��ջ����д�������� output_s
 *  1. ��������д�����ݵ�ʱ��,���ݶ��ǲ��� input_s��.
 *  2. ��������Ҫ��ȡ����,������Ҫ�����ݵ�ʱ��,����ͨ��output_s������
 *      -> ��������,�����ж�output_s���Ƿ����Ԫ��,���������ֱ����ջ����ȡ�������.
 *      -> ���output_s�в�����Ԫ��,��input_s�е�Ԫ��һ��ȡ����ŵ�output_s��,Ȼ��ִ������Ĳ���.
 *      -> ������������ж�������Ԫ��˵��Ϊ��.
 *
 * ע��:���ջΪ�յ�ʱ�� peek��popӦ����ʲô���
 *
 */

public class _203ջ_����_232 {

    @Test
    public void main() {
        System.out.println("��ʼ");


    }

    class MyQueue {
        private Stack<Integer> input_s;
        private Stack<Integer> output_s;

        public MyQueue() {
            input_s = new Stack();
            output_s = new Stack();
        }

        public void push(int x) {
            input_s.push(x);
        }

        public int pop() {
            if (output_s.empty()) {
                exchange(input_s,output_s);
            }
            return output_s.pop();
        }

        public int peek() {
            if (output_s.empty()) {
                exchange(input_s,output_s);
            }
            return output_s.peek();
        }

        private void exchange(Stack input, Stack output) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }

        public boolean empty() {
            return input_s.empty() && output_s.empty();
        }
    }



}