package 未完成;

import java.util.LinkedList;

import org.junit.Test;

/*
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。写入数据 put(key, value) 
- 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
进阶:
	你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:
	LRUCache cache = new LRUCache( 2 ); //缓存容量 
	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // 返回  1
	cache.put(3, 3);    // 该操作会使得密钥 2 作废
	cache.get(2);       // 返回 -1 (未找到)
	cache.put(4, 4);    // 该操作会使得密钥 1 作废
	cache.get(1);       // 返回 -1 (未找到)
	cache.get(3);       // 返回  3
	cache.get(4);       // 返回  4
 */
/*
 * 页面置换算法LRU:在一个固定内存的街都中当你的内存不够用时他会邮箱删除,
 * 		你最长时间没有访问过的数据以提供,提供可用的访问空间.
 * 
 * 思路1:利用双向链表的一个结构和hashmap来实现,hashmap用来存放数据键值对(K,V)
 * 	(1)每一次执行put操作,
 * 		先判断是否会溢出,如果内存溢出,则将链表尾部的K删除,并将其map中的键值对删除
 * 		再查询一下在map中是否存在K(新增K),如果存在将Map对应的V更新,并在将list中的K其移动到头部,
 * 		如果不存在将KV直接添加到map中,并将K添加倒头部,	
 * 	(2)每一次执行get操作,先查询一下map中是否存在K,
 * 		存在将其对应的V返回,并且list中的K移动到头部.
 * 		不存在返回-1;
 * 	(3)Pop操作,判断如果map中存在此K,则将V返回,并将看删除,然后将list中的K删除
 * 
 * 注意:此处的双端队列需要我们自己定制,因为map中和list中实际上是存的一个指向.我可以直接通过map,定位到
 * list中的某个节点,然后通过pro和next来进行调整.而jvm提供的linkedlist节点不具备此功能
 * 
 */
public class _07页面缓存算法LRU {
	
	@Test
	public void main() {
		LinkedList<Integer> linklist = new LinkedList<Integer>();
		
	}
	
	//一个缓存对象
	class LRUCache {

	    public LRUCache(int capacity) {
	        
	    }
	    
	    public int get(int key) {
	        return 1;
	    }
	    
	    public void put(int key, int value) {
	        
	    }
	}

}
