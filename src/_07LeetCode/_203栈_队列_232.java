package _07LeetCode;
import org.junit.Test;
import java.util.Stack;

/**
 * 链接:https://leetcode.cn/problems/implement-queue-using-stacks/
 *  用栈实现队列
 *
 *  思路1:使用两个栈来实现一个队列
 *  两个栈的作用,一个栈负责写入数据 input_s ,另外一个栈负责写数据数据 output_s
 *  1. 当队列入写入数据的时候,数据都是插入 input_s中.
 *  2. 当队列需要读取数据,或者需要出数据的时候,则是通过output_s来操作
 *      -> 操作流量,首先判断output_s中是否存在元素,如果存在则直接在栈顶读取或出数据.
 *      -> 如果output_s中不存在元素,则将input_s中的元素一次取出后放到output_s中,然后执行上面的操作.
 *      -> 如果两个队列中都不存在元素说明为空.
 *
 * 注意:如果栈为空的时候 peek和pop应该是什么结果
 *
 */

public class _203栈_队列_232 {

    @Test
    public void main() {
        System.out.println("开始");


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