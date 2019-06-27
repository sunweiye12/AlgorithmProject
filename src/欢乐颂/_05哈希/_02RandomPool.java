package 欢乐颂._05哈希;

import java.util.HashMap;

import org.junit.Test;

/**
 * 设计RandomPool结构
	【题目】 设计一种结构，在该结构中有如下三个功能：
		1.insert(key)：将某个key加入到该结构，做到不重复加入。
		2.delete(key)：将原本在结构中的某个key移除。 
		3.getRandom()：等概率随机返回结构中的任何一个key。
	
	【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
	
	思路:题目中实现的是一个单列集合的结构(类似于HashSet),但是多了一个getRandom()方法,二且要求时间复杂度都为O(1)
		因此可以利用两个双列集合(HashMap)来实现,
			map1-->HashMap<String,Integer>
			map2-->HashMap<Integer,String>
			维护一个size变量作为集合的大小
		insert(key)方法将元素
 * @author Administrator
 *
 */
public class _02RandomPool {
	
	@Test
	public void main() {
		RandomPool pool = new RandomPool();
		pool.insert("1");
		pool.insert("2");
		pool.delete("2");
		
		String str = pool.getRandom(); 
		System.out.println(str);
		
	}
	
	
	
	class RandomPool{
		HashMap<String,Integer> map1;
		HashMap<Integer,String> map2;
		int size = 0;
		public RandomPool(){
			map1 = new HashMap<String, Integer>();
			map2 = new HashMap<Integer,String>();
		}
		
		//添加元素
		public void insert(String key) {
			if (map1.containsKey(key)) {
				throw new RuntimeException("已包含此元素-->"+key);
			}
			size++;
			map1.put(key, size);
			map2.put(size, key);
		}
		
		//删除元素
		public void delete(String key) {
			if (!map1.containsKey(key)) {
				throw new RuntimeException("集合不存在此元素-->"+key);
			}
			int deleteIndex = this.map1.get(key);
			int lastIndex = size--;
			String lastKey = map2.get(lastIndex);
			map1.put(lastKey, deleteIndex);
			map2.put(deleteIndex, lastKey);
			map1.remove(key);
			map2.remove(lastIndex);
			
		}
		
		//随机获得元素
		public String getRandom() {
			if (this.size == 0) {
				return null;
			}
			int randomIndex = (int) (Math.random() * this.size+1); // 1 ~ size
			return map2.get(randomIndex);
		}
	}

}
