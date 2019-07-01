package _1bytedance;

/*
 * 思路:构建一个help的数组和arr数组对应,找到最小的那和数,然后将其对应位置置为1
 * 		然后从这里开始扩散,相邻的比自己大的则对应位置大,比自己小的则对应位置要小,如果相等的话都有可能
 */
public class 分糖 {

	public static void main(String[] args) {
//		int[] arr = {8,9,10,8,7};
		int[] arr = {2,3,3,4,5,2,1};
		int num = getMinNum(arr);
		
		System.out.println(num);
	}
	
	
	private static int getMinNum(int[] arr){
		int[] help = new int[arr.length]; //创建一个辅助数组
		int minNum = Integer.MIN_VALUE;
		partion(arr, minNum, help);
		int su = 0;
		for (int i = 0; i < help.length; i++) {
			su += help[i];
		}
		return su;
	}
	private static void partion(int[] arr,int minNum,int[] help) {
		int temNum = Integer.MAX_VALUE; //全局最小值
		int minindex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= minNum && help[i] == 0) { //首先我只找没有分过糖且找比我大的
				if (arr[i] < temNum) {//然后在从这里面找出对小的返回下表
					temNum = arr[i];
					minindex = i;
				}
			}
		}
		//得到了当前的最小值的位置
		if (minindex == -1) { //说明已经不存在最小值
			return;
		}
		//判断最右两边的情况
		int left = minindex - 1 < 0 ? 0 : help[minindex - 1]; //左面的糖数
		int right = minindex + 1 >= arr.length ? 0 : help[minindex + 1]; //右面的糖数
		help[minindex] = Math.max(left, right) + 1;
		partion(arr,temNum,help);
	}
}
