package C07LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个字符串 s，请你找出其中不含重复字符的最长子串长度。
 * 示例
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 最长无重复字符子串是 "abc"
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 最长无重复字符子串是 "wke"
 */
public class C504不含重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(getReslutNum("pwwkew"));
    }

    public static int getReslutNum(String s) {
        Map<Character, Integer> index = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {

            char cur = s.charAt(right);
            if (index.containsKey(cur)) {
                left = Math.max(left, index.get(cur) + 1);
            }

            index.put(cur, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

