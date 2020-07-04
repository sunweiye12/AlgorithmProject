package _04剑指offer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * 思路:可以用hashmap来实现,其中key为字符,value为此字符出现的下标
 * 		利用set结构来标记那些已经重复的元素
 * 		1.每次放元素的时候判断时候存在此set中是否存在,如果存在直接跳过,如果不存在判断hashmap中是否存在,
 * 			如果hashmap中不存在,则将元素添加到map中,
 * 			如果存在就此key重复了,将其在HahsMap总删除,并将此元素放入到set集合中
 * 		2.然后通过遍历一遍找到下标最小那个key几位所求
 * 	时间O(n) 空间:由于一共包含256个字符,所以做多开放的空间都为256,因此为O(1)
 */
public class _35第一个只出现一次的字符 {

	@Test
	public void main() {
		
		String str = "googgle";
		int i = FirstNotRepeatingChar(str);
		System.out.println(i);
	}
	
	public int FirstNotRepeatingChar(String str) {
		//basecase
		if (str == null || "".equals(str)) {
			return -1;
		}
		char[] arr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) { //如果set中包含此元素,直接跳过不包含
				if (!map.containsKey(arr[i])) { //如果map中不包含则添加到map总,否则在map中删除并添加到set中
					map.put(arr[i], i);
				} else{
					map.remove(arr[i]);
					set.add(arr[i]);
				}
			} 
		}
		if (map.isEmpty()) {
			return -1;
		}
		Collection<Integer> values = map.values();
		int ret = Integer.MAX_VALUE;
		for (Integer integer : values) {
			ret = Math.min(ret, integer);
		}
        return ret;
    }
}
