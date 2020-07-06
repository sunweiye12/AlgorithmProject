package _05LeetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*给出一个字符串得到其中没有在重复字符的最长字符串长度
 * 思路:利用滑动窗口法思路来解题
 * 1.记录当前的长度为len=0,forward,behind别为前后指针
 * 2.前面指针如果没有越界就向下走,判断hashset中是否含有当前元素,如果含有就添加,
 * */
public class _03无重复字符的最长子串<lengthOfLongestSubstring1> {

    @Test
    public void test() {
        String str = "pwwkew";
        int len = lengthOfLongestSubstring1(str);
        System.out.println(len);    // 3
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //创建hashset
        Set charSet = new HashSet();
        //创建前后指针和长度
        int len = 0;
        int forward = 0;
        int behind = 0;
        while (behind <= forward && forward < s.length()) {
            if (len >= (s.length() - behind)) break;
            if (!charSet.contains(s.charAt(forward))) {
                charSet.add(s.charAt(forward));
                len = Math.max(len, forward - behind + 1);
                forward++;
            } else {
                charSet.remove(s.charAt(behind++));
            }
        }
        return len;
    }

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
