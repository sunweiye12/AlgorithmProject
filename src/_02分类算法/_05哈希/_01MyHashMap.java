package _02分类算法._05哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class _01MyHashMap {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("zuo", "31");

		System.out.println(map.containsKey("zuo"));
		System.out.println(map.containsKey("chengyun"));
		System.out.println("===========1==============");

		System.out.println(map.get("zuo"));
		System.out.println(map.get("chengyun"));
		System.out.println("==========2===============");

		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("==========3===============");

		System.out.println(map.remove("zuo"));
		System.out.println(map.containsKey("zuo"));
		System.out.println(map.get("zuo"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("==========4===============");

		map.put("zuo", "31");
		System.out.println(map.get("zuo"));
		map.put("zuo", "32");
		System.out.println(map.get("zuo"));
		System.out.println("==========5===============");

		map.put("zuo", "31");
		map.put("cheng", "32");
		map.put("yun", "33");

		for (String key : map.keySet()) {
			System.out.println(key);
		}
		System.out.println("==========6===============");

		for (String values : map.values()) {
			System.out.println(values);
		}
		System.out.println("===========7==============");

		map.clear();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("===========8==============");

		// you can not remove item in map when you use the iterator of map
//		 for(Entry<String,String> entry : map.entrySet()){
//			 if(!entry.getValue().equals("1")){
//				 map.remove(entry.getKey());
//			 }
//		 }

		//删除Hashmap中的一系列值
		List<String> removeKeys = new ArrayList<String>();	//创建一个集合存放要删除的Key
		for (Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("1")) {	//将不符合逻辑的Key放入删除结合中
				removeKeys.add(entry.getKey());
			}
		}
		for (String removeKey : removeKeys) {	//逐一删除集合包含的元素
			map.remove(removeKey);
		}
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("==========9===============");

	}
}
