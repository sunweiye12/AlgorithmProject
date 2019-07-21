package 剑指offer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 	例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 	当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 * 
 * 思路:可以利用hashmap来实现,其中key为此元素,而value为其所在的下标
 * 		每次将put元素时,安排你但是否存在,若果存在则删除,如果不存在则将其值和对应的下标 放到map中
 * 		最后得到所有map中的value,选择最小的,将其值返回
 */
public class _55字符流中第一个不重复的字符 {

	@Test
	public void main() {
		
	}
	
	public String str = "";
	
    public void Insert(char ch){
        str += ch;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                map.remove(arr[i]);
            } else{
                map.put(arr[i],i);
            }
        }
        if(map.size()==0){
            return '#';
        }
        //用于返回的元素
        boolean flag = false;
        char ret = '#';
        Set<Character> keySet = map.keySet();
        for (Character keys : keySet) {
        	if(!flag){
        		ret = keys;
        		flag = true;
        	} else{
        		ret = map.get(ret) < map.get(keys)? ret: keys;
        	}
		}
        return ret;
    }
}
