package _07LeetCode;

import org.junit.Test;

import java.security.Key;
import java.util.*;


/**
 * 链接: https://leetcode.cn/problems/group-anagrams/description/
 *  
 *  疑问：字母中是否区分大小写？是否会穿入空数组，空数组或者null 的时候预期的结果是什么？单词中可能会出翔相同字母
 *  字母异位词：首先要长度相同，有相同的字母拼成的单词。
 *
 *  思路：关键点是如何识别出一组，思路是通过Hash。  O(n * mlogm)
 *
 *
 *  暴力思路：先将所有数组排序，然后在将数据排序，最后从左到右拿到相同的元素的为一组，
 *  注意：数组排序的时候，将原始数组复制出来一份操作，并在排序的时候保留原来的下标，一遍返回结果使用。
 *
 *  两次排序 时间复杂度 O(n*mlogm）+ O（nlongn） + O(n) = O(n * mlogm)？O(nlogn)
 *  空间O(n*m）
 *
 */

public class _405哈希表_字母异位词分组49 {

    @Test
    public void main() {
        System.out.println("开始");
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> listList = groupAnagrams(arr);
        System.out.println(listList);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<String, List<String>>(); // key 是排序后(归一化)的值，value事真实的值
        for (String key : strs) {
            char[] charArray = key.toCharArray();
            Arrays.sort(charArray);
            String mapKey = String.valueOf(charArray);
//            if (map.containsKey(mapKey)) {
//                map.get(mapKey).add(key);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(key);
//                map.put(mapKey, list);
//            }
            List<String> valueTmp = map.getOrDefault(mapKey, new ArrayList<>());
            valueTmp.add(key);
            map.put(mapKey, valueTmp);
        }

        return new ArrayList<>(map.values());
    }

}