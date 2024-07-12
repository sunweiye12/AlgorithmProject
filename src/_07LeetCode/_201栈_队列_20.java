package _07LeetCode;
import org.junit.Test;
import sun.jvm.hotspot.tools.JStack;

import java.util.HashSet;
import java.util.Stack;

/**
 * ����:https://leetcode.cn/problems/valid-parentheses/description/
 *  �ж���������Ч������.
 *  '('��')'��'{'��'}'��'['��']'
 *  ()[]{}
 *  ((())[])
 *  ()])
 *  ({[})]
 *
 *  ˼����:
 *  1. ����ַ���Ϊ�ջ���null,Ӧ����ô����(����true?)
 *  2. �ǲ���ֻ���⼸���ַ������?
 *
 *  ˼·1:��������.��Ҫ����len/2��ѭ��
 *      ÿһ��ѭ����'()'�滻Ϊ'','[]'�滻Ϊ'','{}'�滻Ϊ''
 *      ѭ����ɺ���ַ������Ϊ����Ϸ�,����replace����ʱ�临�Ӷȸ�,��˲��Ƽ�.
 *
 *  ˼·2: ͨ��ջ�ṹ��ʵ��.
 *      ����������������Ƶ�ջ��,���������������ջ����Ԫ�ر����Ƕ�Ӧ��������,�������pop��Ӧ��ջ��Ԫ��,���򷵻ز��Ϸ�.
 *      ���������ַ�����,ջ�е�Ԫ������Ϊ��.
 *      ʱ��O(n)  �ռ�O(n)
 *
 */

public class _201ջ_����_20 {

    @Test
    public void main() {
        System.out.println("��ʼ");

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

    // �Ż��汾
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