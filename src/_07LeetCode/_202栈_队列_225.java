package _07LeetCode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

/**
 * 链接:https://leetcode.cn/problems/implement-stack-using-queues/description/
 *  用队列实现栈
 *
 *  思路1:使用两个队列来实现一个栈的功能
 *  两个队列的功能:一个队列只负责写入数据 input_q ,另外一个队列至负责出数据 output_q
 *  操作:当每次想栈中写数据的时候,我们将数据
 */

public class _202栈_队列_225 {

    @Test
    public void main() {
        System.out.println("开始");

        System.out.println(isValid0("({})[]"));
    }

    public boolean isValid0(String s) {
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) {
            s = s.replace("()","").replace("[]","").replace("{}","");
        }
        return s.equals("");
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<Character>();
        HashSet<Character> zuo = new HashSet<Character>();
        zuo.add('(');
        zuo.add('[');
        zuo.add('{');

        for (int i = 0; i < s.length(); i++) {
            if (zuo.contains(s.charAt(i))) {
                st.push(s.charAt(i));
            } else {
                if (st.empty()) return false;
                if (st.pop() != getZuo(s.charAt(i)))  return false;
            }
        }
        return st.empty();
    }

    public char getZuo(char s) {
        switch (s) {
            case ']': return '[';
            case '}': return '{';
            case ')': return '(';
            default: return '-';
        }
    }

    // 优化版本
    public boolean isValid1(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(')');
            else if (s.charAt(i) == '[') st.push(']');
            else if (s.charAt(i) == '{') st.push('}');
            else if (st.empty() || st.pop() != s.charAt(i)) return false;
        }
        return st.empty();
    }



}