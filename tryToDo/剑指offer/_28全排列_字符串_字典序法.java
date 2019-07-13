package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/*
 *字典序法:
 * 一个全排列可看做一个字符串，栈找到所有全排列中最小的全排列,然后依次找到最下一个,直到最大的全排列。
 * 在我们寻找下一个全排列时,要求下一个和前一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
 * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
 * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
 * 【例】 如何得到346987521的下一个
 * 1，从尾部往前找第一个P(i-1) < P(i)的位置(找到第一个出现下降的位置)
 * 		3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
 * 		最终找到6是第一个变小的数字，记录下6的位置i-1
 * 2，从i位置往后找到最后一个大于6的数(找到最后一个比下降位置大的元素)
 * 		3 4 6 -> 9 -> 8 -> 7 5 2 1
 * 		最终找到7的位置，记录位置为m
 * 3，交换位置i-1和m的值(交换)
 * 		3 4 7 9 8 6 5 2 1
 * 4，倒序i位置后的所有数据(将下降位置的后缀,倒序)
 * 		3 4 7 1 2 5 6 8 9
 * 		则347125689为346987521的下一个排列
 */
public class _28全排列_字符串_字典序法 {

	@Test
	public void main() {
		String str = "123";
		ArrayList<String> list = Permutation2(str);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	//字典序解决方案
	public ArrayList<String> Permutation2(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars); //排序得到最小的全排列
        list.add(String.valueOf(chars)); //将此全排列添加
        
        int len = chars.length;
        while(true){
            int lIndex = len-1; //左索引
            int rIndex;			//右索引
            //从后向前查询,找到第一个下降的字符(为lIndex-1的位置)
            while(lIndex > 0 && chars[lIndex-1] >= chars[lIndex]){
                lIndex--;
            }
            //如果第一个下降的位置在0以前,就说明已经查到了最大全排列,没有比他还大的全排列(直接退出)
            //目的是找出比当前大一的全排列,并返回,因此最大的这个应该在前面已经返回了
            if(lIndex == 0)
                break;
            //找到它后面最后一个比它大的元素(返回坐标为rIndex-1)
            rIndex = lIndex;
            while(rIndex < len && chars[lIndex - 1] < chars[rIndex]){
                rIndex++;
            }
            //将两个元素交换
            swap(chars,lIndex-1,rIndex-1);
            //将lIndex后的后缀反转(包含lIndex)-->获取到了下一个元素
            reverse(chars,lIndex);
            list.add(String.valueOf(chars));
        }
        return list;
    }
 
	//将包含k下标的元素反转
    private void reverse(char[] chars,int k){
        if(chars==null || chars.length<=k)
            return;
        int len = chars.length;
        //相当于找到对称中心然后反转
        for(int i=0;i<((len-k)/2);i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
            }
        }
    }
	    
    //交换两个元素
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
