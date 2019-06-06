package 欢乐颂._08贪心策略;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

/**
 * 题目:给定两个字符数组arr1和arr2,判断在arr2中哪些字符是arr1中出现的?并打印此字符和其在arr1中出现的次数
 
 * 思路1: 1.对arr1中的字符进行词频统计,创建一个HashMap结构,key为字符,value为此字符出现的次数
 * 		从arr1的第一元素开始,将其放入hashmap中,并记录其次数
 * 	    2.对arr2进行遍历(进行去重),依次查找arr2中的每一个元素是否包含在hashmap的key中,如果包含则打印此元素和hashmap
 * 		中对应的value值
 * 
 * @author Super PC
 *
 */
public class _01一个字符串中包含的另一个字符串的字符 {
	@Test
	public void main() {
		String str1 = "12121211";
		String str2 = "12134";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		//打印arr1中包含的arr2的字符和其次数
		twoContentPrint(arr1,arr2);
		
	}

	//打印arr1中包含的arr2的字符和其次数
	private void twoContentPrint(char[] arr1, char[] arr2) {
		//创建用于词频统计的hashmap
		HashMap<Character, Integer> charSize = new HashMap<Character, Integer>();
		//将arr1中的字符都放到hashmap中
		for (int i = 0; i < arr1.length; i++) {
			if (charSize.containsKey(arr1[i])) {
				charSize.put(arr1[i], charSize.get(arr1[i])+1);
			}else {
				charSize.put(arr1[i], 1);
			}
		}
		
		//对arr2进行去重处理
		HashSet<Character> set = new HashSet<Character>();//用于判重
		List<Character> arr2list = new ArrayList<Character>();//用于盛放元素
		for (int i = 0; i < arr2.length; i++) {
			if (!set.contains(arr2[i])) {
				set.add(arr2[i]);
				arr2list.add(arr2[i]);
			}
		}
		
		for (int i = 0; i < arr2list.size(); i++) {
			if (charSize.containsKey(arr2list.get(i))) {
				System.out.println(arr2list.get(i)+":"+charSize.get(arr2list.get(i)));
			}
		}
		
	}
}