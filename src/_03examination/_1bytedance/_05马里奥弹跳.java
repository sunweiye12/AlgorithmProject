package _03examination._1bytedance;

import org.junit.Test;

/*
 * 题目:马里奥通过弹跳到达终点,给定一个数组{10,0,2,1,1,0,1,终点},可以向前跳可以向后跳,每个位置的数代表弹板弹跳的最长距离
 * 		给定你起始的位置index,你返回它跳到终点的最小弹跳次数.
 * 		注意:为0的位置为悬崖,如果调跳到悬崖中说明失败,则返回-1
 * 暴力递归:拿到index首先判断,index位置是否为0,如果是就返回-1,然后看从index下能不能直接跳到终点,如果能,就返回 1,如果生在终点返回0
 * 		然后判断他能跳到那个位置,利用递归函数实现,最后返回,最小的弹跳次数
 * 记忆化搜索:
 */
public class _05马里奥弹跳 {
	
	@Test
	public void main() {
		int[] arr = {10,0,2,1,1,0,1};
		int index = 3; //第四个位置,下标为3的位置
		int[] help = new int[arr.length]; //记忆化搜索的缓存数组
		int step = getStepNum(arr , index);
		System.out.println(step);
	}

	private static int getStepNum(int[] arr, int index) {
		int[] help = new int[arr.length]; //用来标记那个位置被跳过了
		return parttion(arr,help,index);
	}

	private static int parttion(int[] arr, int[] help, int index) {
		//basecase
		if (arr[index] == -1) return -1;
		if (index == arr.length) return 0;
		if (index + arr[index] >= arr.length) return 1;
		
		int minStep = Integer.MAX_VALUE;//全局最小值
		for (int i = -arr[index]; i <= arr[index]; i++) { //能够跳跃的范围
			//如果当前位置没有来到过并且没有越界,则可以跳
			if (index+i >= 0 && index+i < arr.length && help[index+i] == 0) { 
				help[index+i] = 1;//表示当前位置来过
				int tempStep = parttion(arr, help, index+i);
				if (tempStep != -1) { //只有当下一个位置不是悬崖,我们才跳
					minStep = Math.min(minStep, tempStep + 1);
				}
			}
		}
		int result = minStep == Integer.MAX_VALUE ? -1: minStep;
		return result;
	}

}
