package _07LeetCode;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.*;


/**
 * 链接:https://leetcode.cn/problems/valid-anagram/description/
 *  
 *  疑问：首先就是如果这两个string的长度不一样的话那返回肯定就是false
 *      数组中会存在重复的元素
 *
 *  思路1：将两字符串排序，然后依次对比每个位置的元素是否一样
 *      时间 O(n * logn) 空间O(n)
 *
 *  思路2:首先将两个字符串转成数组，然后创建一个map（key尾字符，value尾字符出现的此处）。
 *      将数组1 按照上面的规则依次添加到map中。
 *      然后依次遍历数组2的元素，如果在map中存在则对应的value - 1，如果value为0的时候就移除这个元素。
 *      中间存在不存在，或者最后结果map部位空的时候，即返回false；
 *
 */

public class _401哈希表_有效的字母异位词242 {

    @Test
    public void main() {
        System.out.println("开始");


        System.out.println(isAnagram2("catt","tact")); // 返回 4
    }

    //思路1
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