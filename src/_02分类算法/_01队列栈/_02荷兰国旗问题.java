package _02分类算法._01队列栈;

import org.junit.Test;

/**
 * 	荷兰国旗问题:给定一个数组arr，和一个数num，请把小于num的数放在数组的
		左边，等于num的数放在数组的中间，大于num的数放在数组的右边
		
	要求:额外空间复杂度O(1)，时间复杂度O(N)
 * @author Administrator
 *
 *思路: 设置三个指针less指向起始位置减一,more指向末尾位置加一,cur指向起始位置,
 *		当num小于cur指向的数字,将它和less下一个的位置交换,cur++
 *		当num等于cur指向的数字.则cur++
 *		当num大于cur指向的数字,将它和more前一个的位置交换
 *		直到more和cur相遇
 */

public class _02荷兰国旗问题 {
	
	@Test
	public  void main() {
		int[] arr = {-34 ,-19, 33, 62, 85, -31, -70, -57, -68};
		int num = 3300;
		int[] test = test(arr, 0, arr.length-1, num);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+" ");
		}
	}
	
	//返回相等部分的下标值   ---> 参数为 数组,左边界,右边界,要比较的数
	public int[] test(int[] arr, int L ,int R ,int num){

		int less =L - 1;	//小于numb的指针
		int more =R + 1;	//大于num的
		int cur = L;		//等于num的指针
		
		while (cur < more) { 		//只要cur与more没有相遇就一直循环
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);		//此处cur不能加一,因为移过来的more--还没有经过判断,且需要判断
			} else {		//相等情况
				cur++;
			}
		}
		
		if(less+1>more-1){  //如果输入的num不存在数组中,则返回一个数
			return new int[]{0};
		}
		//若数组中存在num则返回存在num的下标范围
		return new int[] {less+1,more-1};
	}
	
	//交换数组a下标和b下标的元素
	public void swap(int[] arr , int a ,int b){
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}
}
