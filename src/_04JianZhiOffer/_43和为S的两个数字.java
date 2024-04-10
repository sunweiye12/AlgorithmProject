package _04JianZhiOffer;
import java.util.ArrayList;

import org.junit.Test;
/*
 *题目:输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 *思路:	第一个位置作为第1个元素开始向下找第2个元素,直到连个元素的和等于sum,超过sum时结束
 *	  	在以第二位置作为第1个元素始向下找第2个元素,同理
 *		直到找到头,或者超过sum/2时结束,如果没找到返回空,否则返回乘机最小的元素
 */
public class _43和为S的两个数字 {
	@Test
	public void main() {
		int[] arr = {1,2,6,7,8,9};
		int sum = 9;
		ArrayList<Integer> list = FindNumbersWithSum(arr,sum);
		System.out.println(list);
	}

	public ArrayList<Integer> FindNumbersWithSum(int [] arr,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();  //用于返回的结果
		//basecase
		if (arr == null || arr.length < 2) {
			return list;
		}
		for (int x = 0; x < arr.length && arr[x] <= sum/2; x++) { //起点
			for (int y = x+1; y < arr.length; y++) {  //从x的洗衣歌位置开始找第二个元素
				if (arr[x] + arr[y] == sum) {
					list.add(arr[x]);
					list.add(arr[y]);
				}
			}
		}
		int num = list.size()/2; //一共有num对元素
		if (num == 0) {
			return list;
		} else{
			//得到第一对
			int tem1 = list.remove(0); 
			int tem2 = list.remove(0);
			for (int i = 1; i < num; i++) {
				int tem3 = list.remove(0); 
				int tem4 = list.remove(0); 
				if ((tem1*tem2)>(tem3*tem4)) {
					tem1 = tem3;
					tem2 = tem4;
				}
			}
			list.add(tem1);
			list.add(tem2);
			return list;
		}
    }
}
