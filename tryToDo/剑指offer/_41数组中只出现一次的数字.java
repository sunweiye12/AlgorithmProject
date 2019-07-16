package 剑指offer;

import org.junit.Test;

/*
 * 题意:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 
 * 思路:此题为位运算考察,当进行异或运算时,与一个数进行异或两次,所得大结果与异或之前相同,
 * 		因此当数组中只有一个数出现了一次,其他的数都出现了两次的话,将数组中所有数一次异或就可以得到出现一次的数
 * 	思路同上,既然数组中存在两个只出现一次的数,则可以将数组分成两部分
 * 	活粉策略为:将数组中所有位都进行异或运算,左后获得的数一定是这两个特殊的数异或的结果,且不为0
 * 	我们可以通过这个数,然后找到这个数中的第一个不为0的二进制位,然后通过此位为0和不为0将数组划分成两部分
 * 	(这样相同的数一定会分到一组,两个特殊的数一定分到了两组)
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class _41数组中只出现一次的数字 {
	
	@Test
	public void main() {
		int[] arr = {2,4,3,6,3,2,5,5};
		int[] num1 = {0};
		int[] num2 = {0};
		FindNumsAppearOnce(arr,num1,num2);
	}
	
	public void FindNumsAppearOnce(int[] arr,int num1[] , int num2[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int tem =arr[0];
		for (int i = 1; i < arr.length; i++) {
			tem ^= arr[i];
		}
		//判断某一位不为0
		int index = 0; //从第1位开始,tem的第index位为1
		while((tem & 1) == 0 && index < 32){
			tem >>= 1;
			index++;
		}
		//通过index来将数组分成两部分
		for (int i = 0; i < arr.length; i++) {
			int s = arr[i];		//找一个数来作为中介
			if (((s >> index) & 1)==1) {
				num1[0] ^= arr[i];
			} else{
				num2[0] ^= arr[i];
			}
		}
		System.out.println(num1[0]+"--"+num2[0]);
	}
}
