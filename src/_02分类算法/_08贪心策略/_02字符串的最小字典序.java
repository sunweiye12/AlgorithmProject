package _02分类算法._08贪心策略;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

/**
 * 题目:给定你一个字符串数组,你需要将所有字符串拼接成一个最小字典序的字符串,并返回=
 * 例如: arr = {"ab","bd","c"}
 *     返回  "abbdc" 
 * 例如: arr = {"ba","b"}
 *     返回  "bab" 
 *字典序:对于两个长度相等的字符串"abc" "bcd"他俩的实际顺序就是真实字典序
 *		对于长度不同的字符串在长度短的后面追加最小的单字符就可以比较了  例如"abc" "b" 可以用"abc" "b00"来比较
 *策略:
 *	现在想的是给你[5,2,3,4,8,2,3] 这个数组,你可以运用排序算法,将他排序好就是最小序
 *	运用到此题中就相当于为字符串数组定义一个排序策略,然后Arrays.Sort()方法,添加有比较策略的比较器就可以了
 *	此处添加的比较策略为:
 *			如果str1+str2 <= str2+str1 则str1放前面,否则str2放前面
 * @author Administrator
 *
 */

public class _02字符串的最小字典序 {

	@Test
	public void main() {
		
		String[] arr = {"ba","b","abc"};  //abcbab
		String result = getLowDicorder(arr);
		System.out.println(result);
		
	}
	
	
	//返回所给的字符串数组拼成的最小字典序的字符串
	private String getLowDicorder(String[] arr) {
		//通过设定的比较策略来进行排序
		Arrays.sort( arr,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);  //字符串内置的比较方法compareTo
			}
		});
		
		String result = "";
		//将排序好的字符串数组拼接成字符串
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
}
