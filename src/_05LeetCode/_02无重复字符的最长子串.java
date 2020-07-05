package _05LeetCode;

import org.junit.Test;

/*给出一个字符串得到其中没有在重复字符的最长字符串长度*/
public class _02无重复字符的最长子串 {

    @Test
    public void test() {
        String str = "abcabcbb";
        int len = lengthOfLongestSubstring(str);
        System.out.println(len);    // 3
    }

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
