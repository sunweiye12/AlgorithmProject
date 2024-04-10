package _04JianZhiOffer;

import org.junit.Test;

/*
 * 题目:牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 	但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * 	Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 
 * 思路:同样课可以利用数组来实现反转,获取数组的长度len,反转len/2此即可
 * 		注意:人家只是单词的顺序是到了,但是每个单词没有倒,因此上面的思路有误
 * 		可以先透过split方法将原来的字符串切割,然后在按照上面的思路进行
 */
public class _45翻转单词顺序列 {
	
	@Test
	public void main() {
//		String str = "student. a am I";
		String str = " ";
		String str1 = ReverseSentence(str);
		System.out.println(str1+"-");
	}
	
	public String ReverseSentence(String str) {
		//basecase
		if(str==null || str.equals("")){
			return "";
		}
		if(str.equals(" "))
			return " ";
		String[] arr = str.split(" ");
		int size = arr.length/2;
		for (int i = 0; i < size; i++) {
			swap(arr,i,arr.length-1-i);
		}
		String ret = "";
		for (String c : arr) {
			ret += c+" ";
		}
		return ret.trim();
    }

	private void swap(String[] arr, int i, int j) {
		String tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;		
	}
}
