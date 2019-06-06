package _0工具箱类;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class _06找出一个字符串的所有子串 {
	
	@Test
	public void main() {
		//8888返回一个字符串中所有子串所组成的集合
		String str = "123456";
		List<String> parList = Participle(str);  //返回的集合中包含了所有的子串
		for (int i = 0; i < parList.size(); i++) {
			System.out.print(parList.get(i)+" ");
		}
		System.out.println( );
		
		//8888传入一个数组,返回此数组的所有子数组的集合
		int[] arr = {1,2,3,4,5,6};
		List<int[]> parList1 = Participle1(arr); //返回的集合中包含了所有子数组
		for (int i = 0; i < parList1.size(); i++) {
			for (int j = 0; j < parList1.get(i).length; j++) {
				System.out.print(parList1.get(i)[j]);
			}
			System.out.print(" ");
		}
		
	}

	

	//返回一个字符串中所有子串所组成的集合
    public static List<String> Participle(String str){
    	StringBuffer buffer = new StringBuffer(str); //用于分词截取
    	List<String> reList =new ArrayList<String>();//返回分词结果
    	
		for(int i = 0;i < buffer.length()-1; i++){		
			for(int j = i+1; j < buffer.length()+1; j++){	//	此处j=i+1 变成j=i+2则不包含单个元素
				String str12 = buffer.substring(i, j);	//左闭右开
//				System.out.println(str12); //打印子串
				reList.add(str12);
			}
		}
    	return reList;
    }
    
    //传入一个数组,返回此数组的所有子数组的集合
    private List<int[]> Participle1(int[] arr) {
    	List<int[]> reList =new ArrayList<int[]>();//返回分词结果
    	for(int i = 0;i < arr.length-1; i++){		
			for(int j = i+1; j < arr.length+1; j++){	//	此处j=i+1 变成j=i+2则不包含单个元素
				//创建一个新数组
				int[] newarr = new int[j-i];
				for (int k = 0; k < newarr.length; k++) {
					newarr[k] = arr[k+i];
				}
				//将新数组放入集合中返回
				reList.add(newarr);
			}
		}
    	return reList;
	}
}
