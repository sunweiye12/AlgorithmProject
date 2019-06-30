package _1bytedance;

public class 马里奥弹跳 {

	public static void main(String[] args) {
		int[] arr = {10,0,2,1,1,0,1};
		int index = 3;
		int step = getStepNum(arr,index);
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
