package _07LeetCode;
import org.junit.Test;
import sun.jvm.hotspot.tools.JStack;

import java.util.HashSet;
import java.util.Stack;

/**
 * 链接:https://leetcode.cn/problems/valid-parentheses/description/
 *  判断括号是有效的问题.
 *  '('，')'，'{'，'}'，'['，']'
 *  ()[]{}
 *  ((())[])
 *  ()])
 *  ({[})]
 *
 *  思考点:
 *  1. 如果字符串为空或者null,应该怎么处理(返回true?)
 *  2. 是不是只有这几个字符组成呢?
 *
 *  思路1:暴力遍历.需要进行len/2次循环
 *      每一次循环将'()'替换为'','[]'替换为'','{}'替换为''
 *      循环完成后的字符串如果为空则合法,但是replace方法时间复杂度高,因此不推荐.
 *
 *  思路2: 通过栈结构来实现.
 *      如果遇到左括号则推到栈中,如果遇到右括号则栈顶的元素必须是对应的左括号,如果是则pop对应的栈顶元素,否则返回不合法.
 *      当遍历完字符串后,栈中的元素正好为空.
 *      时间O(n)  空间O(n)
 *
 */

public class _201栈_队列_20 {

    @Test
    public void main() {
        System.out.println("开始");

        System.out.println(isValid0("({})[]"));
        System.out.println(isValid("({})[]"));
        System.out.println(isValid1("({})[]"));

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

        // 栈结构
        Stack<Character> st = new Stack();

        // 左括号集合
        HashSet<Character> zuo = new HashSet();
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

    // 优化版本，太简洁了 直接把对应的右括号放到栈中，少了一次映射
    public boolean isValid1(String s) {
        Stack<Character> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(')');
            else if (s.charAt(i) == '[') st.push(']');
            else if (s.charAt(i) == '{') st.push('}');
            else if (st.empty() || st.pop() != s.charAt(i)) return false;
        }
        return st.empty();
    }



}