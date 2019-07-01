package _1bytedance;

import org.junit.Test;

/*
 * 题目:马里奥通过弹跳到达终点,给定一个数组{10,0,2,1,1,0,1,终点},可以向前跳可以向后跳,每个位置的数代表弹板弹跳的最长距离
 * 		给定你起始的位置index,你返回它跳到终点的最小弹跳次数.
 * 		注意:为0的位置为悬崖,如果调跳到悬崖中说明失败,则返回-1
 * 暴力递归:拿到index首先判断,index位置是否为0,如果是就返回-1,然后看从index下能不能直接跳到终点,如果能,就返回-1,如果生在终点返回0
 * 		然后判断他能跳到哪个位置,利用递归函数实现,最后返回,最小的弹跳次数
 * 记忆化搜索:
 */
public class _05马里奥弹跳 {
	
	@Test
	public void main() {
		int[] arr = {10,0,2,1,1,0,1};
		int index = 3; //第四个位置,下标为3的位置
		int[] help = new int[arr.length]; //记忆化搜索的缓存数组
		int step = getStepJY(arr , help, index);
		System.out.println(step);
	}

	private int getStep(int[] arr, int index) {
		if (arr[index] == 0 || index < 0 || index > arr.length) {
			return -1;
		}
		if (index == arr.length) return 0;  			//生在终点
		if (index+arr[index] >= arr.length) return 1; 	//如果此位置有能力跳跃到终点,则1次就能成功
		
		int minStep = Integer.MAX_VALUE;  //设置一个全局最小值,来返回跳的最小的步数
		for (int i = -arr[index]; i <= arr[index]; i++) {  			//可以往前跳也可以往后跳
			if (index+i >= 0 && index+i < arr.length && i != 0) {	//只要没跳出界,或在自己的地方跳你就跳
				int tempNum = getStep(arr,index+i);//下个位置返回的步数
				if (tempNum != -1) {
					minStep = Math.min(minStep, tempNum+1);
				}
			}
		}
		int result = minStep==Integer.MAX_VALUE?-1:minStep;
		return result;
	}
	
	private int getStepJY(int[] arr, int[] help, int index) {
		if (arr[index] == 0 || index < 0 || index > arr.length) {
			return -1;
		}
		if (index == arr.length) return 0;  			//生在终点
		if (index+arr[index] >= arr.length) return 1; 	//如果此位置有能力跳跃到终点,则1次就能成功
		
		int minStep = Integer.MAX_VALUE;  //设置一个全局最小值,来返回跳的最小的步数
		for (int i = -arr[index]; i <= arr[index]; i++) {  			//可以往前跳也可以往后跳
			if (index+i >= 0 && index+i < arr.length && i != 0) {	//只要没跳出界,或在自己的地方跳你就跳
				//判断缓存是否存在
				if (help[index+i] == 0) {
					int tempNum = getStep(arr,index+i);//下个位置返回的步数
					help[index+i] = tempNum;
				} else{
					int tempNum = help[index+i];
					if (tempNum != -1) {
						minStep = Math.min(minStep, tempNum+1);
					}
				}
			}
		}
		int result = minStep==Integer.MAX_VALUE?-1:minStep;
		return result;
	}
	
	
	private int getStepDP(int[] arr, int index) {
		if (arr[index] == 0 || index < 0 || index > arr.length) {
			return -1;
		}
		if (index == arr.length) return 0;  			//生在终点
		if (index+arr[index] >= arr.length) return 1; 	//如果此位置有能力跳跃到终点,则1次就能成功
		
		int minStep = Integer.MAX_VALUE;  //设置一个全局最小值,来返回跳的最小的步数
		for (int i = -arr[index]; i <= arr[index]; i++) {  			//可以往前跳也可以往后跳
			if (index+i >= 0 && index+i < arr.length && i != 0) {	//只要没跳出界,或在自己的地方跳你就跳
				int tempNum = getStep(arr,index+i);//下个位置返回的步数
				if (tempNum != -1) {
					minStep = Math.min(minStep, tempNum+1);
				}
			}
		}
		int result = minStep==Integer.MAX_VALUE?-1:minStep;
		return result;
	}

}
