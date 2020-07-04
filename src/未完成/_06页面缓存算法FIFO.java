package 未完成;

import java.util.LinkedList;

import org.junit.Test;
/*
 * 页面置换算法FIFO*
 * 题目:设计并实现最不经常使用（FIFO）缓存的数据结构。它应该支持以下操作：get 和 put。
	get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
	put(key, value) - 如果键不存在，则插入新值,如果存在,则将原来的值删除然后插入新值。
	当缓存达到其容量时，它应该在插入新值之前，使最早插入的值无效。
      进阶：
	你是否可以在 O(1) 时间复杂度内执行两项操作*
 
 思路:利用一个双向链表和HashMap的结构来实现,通过HashMap结构来判断,链表中是否存此Key
 	(可以利用hashmap来保存每个key在链表中对应的位置)
 	get()操作:通过HashMap来判断节后中知否存在此Key,如果存在,直接返回链表对应位置的元素
 			不存在的话返回-1
 	put()操作:通过HashMap来判断节后中知否存在此Key,如果存在,则通过HashMap拿到在队列中的位置,将对应位置的元素删除,然后调用不存在的方法.
 			如果不存在,(判断是否到达了capacity)如果没有到达将Key和Value放入到HashMap中
 			然后将Key插入到链表的尾部.
 			如果在put()时达到了capacity

 */
public class _06页面缓存算法FIFO {

	@Test
	public void main() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.remove(0); //默认从头王尾部数
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
//		System.out.println(list.get(3));
	}
	//缓存对象
	class LFUCache {

	    public LFUCache(int capacity) {
	        
	    }
	    
	    public int get(int key) {
	        return 1;
	    }
	    
	    public void put(int key, int value) {
	        
	    }
	}
}
