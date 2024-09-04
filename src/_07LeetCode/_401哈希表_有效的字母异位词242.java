package _07LeetCode;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.*;


/**
 * ����:https://leetcode.cn/problems/valid-anagram/description/
 *  
 *  ���ʣ����Ⱦ������������string�ĳ��Ȳ�һ���Ļ��Ƿ��ؿ϶�����false
 *      �����л�����ظ���Ԫ��
 *
 *  ˼·1�������ַ�������Ȼ�����ζԱ�ÿ��λ�õ�Ԫ���Ƿ�һ��
 *      ʱ�� O(n * logn) �ռ�O(n)
 *
 *  ˼·2:���Ƚ������ַ���ת�����飬Ȼ�󴴽�һ��map��keyβ�ַ���valueβ�ַ����ֵĴ˴�����
 *      ������1 ��������Ĺ���������ӵ�map�С�
 *      Ȼ�����α�������2��Ԫ�أ������map�д������Ӧ��value - 1�����valueΪ0��ʱ����Ƴ����Ԫ�ء�
 *      �м���ڲ����ڣ����������map��λ�յ�ʱ�򣬼�����false��
 *
 */

public class _401��ϣ��_��Ч����ĸ��λ��242 {

    @Test
    public void main() {
        System.out.println("��ʼ");


        System.out.println(isAnagram2("catt","tact")); // ���� 4
    }

    //˼·1
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != t1[i]) return false;
        }
        return true;
    }


    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (map.containsKey(s1[i])) {
                map.put(s1[i], map.get(s1[i]) + 1);
            } else {
                map.put(s1[i], 1);
            }
        }
        for (int i = 0; i < t1.length; i++) {
            if (!map.containsKey(t1[i])) return false;
            if (map.get(t1[i]) == 1) {
                map.remove(t1[i]);
            } else {
                map.put(t1[i], map.get(t1[i]) - 1);
            }
        }
        return map.isEmpty();
    }
}