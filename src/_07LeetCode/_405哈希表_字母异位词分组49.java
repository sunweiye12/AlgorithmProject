package _07LeetCode;

import org.junit.Test;

import java.security.Key;
import java.util.*;


/**
 * ����: https://leetcode.cn/problems/group-anagrams/description/
 *  
 *  ���ʣ���ĸ���Ƿ����ִ�Сд���Ƿ�ᴩ������飬���������null ��ʱ��Ԥ�ڵĽ����ʲô�������п��ܻ������ͬ��ĸ
 *  ��ĸ��λ�ʣ�����Ҫ������ͬ������ͬ����ĸƴ�ɵĵ��ʡ�
 *
 *  ˼·���ؼ��������ʶ���һ�飬˼·��ͨ��Hash��  O(n * mlogm)
 *
 *
 *  ����˼·���Ƚ�������������Ȼ���ڽ������������������õ���ͬ��Ԫ�ص�Ϊһ�飬
 *  ע�⣺���������ʱ�򣬽�ԭʼ���鸴�Ƴ���һ�ݲ��������������ʱ����ԭ�����±꣬һ�鷵�ؽ��ʹ�á�
 *
 *  �������� ʱ�临�Ӷ� O(n*mlogm��+ O��nlongn�� + O(n) = O(n * mlogm)��O(nlogn)
 *  �ռ�O(n*m��
 *
 */

public class _405��ϣ��_��ĸ��λ�ʷ���49 {

    @Test
    public void main() {
        System.out.println("��ʼ");
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> listList = groupAnagrams(arr);
        System.out.println(listList);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ret = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<String, List<String>>(); // key �������(��һ��)��ֵ��value����ʵ��ֵ
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