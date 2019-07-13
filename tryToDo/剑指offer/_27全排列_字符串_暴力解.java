package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 		例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 		输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
* 1、递归算法
 * 固定第一个字符，递归取得首位后面的各种字符串组合；
 * 第一个字符与后面每一个字符交换,得到一组交换后的字符串，
 * 然后让得到的字符串从第二位开始,后面的每一位依次与第二位交换,得到新的字符串....依次进行
 * 直到走到最后一位时结束,将生成的字符串放到list集合里面。
 * 假如有重复值呢？
 * 在每一轮交换开始时创建一个set集合,然后然后交换前判断一下前面是否都相同的元素与打头的交换过了,如果有的话说明没有必要在交换了
 */
public class _27全排列_字符串_暴力解 {

	@Test
	public void main() {
		String str = "abcc";
		ArrayList<String> list = Permutation(str);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	
	public ArrayList<String> Permutation(String str){
        //basecase
        if(str == null || str.length() == 0){
             return new ArrayList<String>();
        }
        //生成一个用于返回的list集合
        ArrayList<String> list = new ArrayList<String>();
        //调用方法,将所有全排列放入list集合中
        partion(str.toCharArray(),0,list);
        //默认根据字典序进行,对集合进行排序
        Collections.sort(list);
        return list;
    }
	    
	//将全排列放入集合中
	private void partion(char[] chars,int i,ArrayList<String> list){
	    //如果到达最后一个元素时,将字符数组转换成字符串,装到list中
	    if(i == chars.length-1){
	        list.add(String.valueOf(chars));
	    }
	    //从第一个元素开始,后面的元素依次与第一个进行交换(如果遇到重复元素则不交换)
	    Set<Character> charSet = new HashSet<Character>(); //为了避免相同元素-->相同元素时只有第一个进行交换
	    for(int j=i;j<chars.length;j++){
	        if(!charSet.contains(chars[j])){ //查一下缓存里面有没有,没有时在进行下一步
	            charSet.add(chars[j]);//将元素放到缓存里
	            swap(chars,i,j);      //开始交换元素
	            partion(chars,i+1,list); //从下一位开始判断
	            swap(chars,i,j);      //再换回来
	        }
	    }
	}
	    
    //交换连个元素
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
