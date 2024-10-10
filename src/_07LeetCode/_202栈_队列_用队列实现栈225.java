package _07LeetCode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 链接:https://leetcode.cn/problems/implement-stack-using-queues/description/
 *  用队列实现栈
 *
 *  思路1:使用两个队列来实现一个栈的功能
 *  这里和使用栈来实现队列不同，因为栈的结构是FILO,所以是能够通过使用两个栈来实现反转从而达到队列的效果。
 *  这里队列则是FIFO，因此即使使用到两个队列，那两个队列倒来倒去实际上元素的顺序没有改变。
 *  因此我们只需要通过一个队列就能够实现栈的功能。假设队列是Q。
 *  employ->返回队列的employ信息。
 *  push-> 直接将元素查到队列Q中。
 *  pop-> 获取当前队列的size(),对队列Q执行 size()-1 次pop操作，并将pop后的元素push到队列尾部，这样原本队尾的元素就到了第一位，直接执行，pop
 *  peek-> 获取当前队列的size(),对队列Q执行 size()-1 次pop操作，并将pop后的元素push到队列尾部，这样原本队尾的元素就到了第一位，
 *          直接执行，peek，执行完后再将其放到队尾Ω
 *
 */

public class _202栈_队列_用队列实现栈225 {


    @Test
    public void main() {
        System.out.println("开始");
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
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