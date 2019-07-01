package _1bytedance;
/*
 * 题目:有N个孩子站成一排，每个孩子有一个分值。给这些孩子派发糖果，需要满足如下需求：
		1、每个孩子至少分到一个糖果
		2、分值更高的孩子比他相邻位的孩子获得更多的糖果
		求至少需要分发多少糖果？
	输入:0,1,0  -->  4
		5,4,1,1  -->  7
		
	思路:构建一个help的数组和arr数组对应,表名此同学分得的糖数
		求一个同学分得的糖数,要分别求两侧分数连续下降的个数,较大的呢个值加1,为此同学的糖数
 */
public class _04分糖果 {
	public static void main(String[] args) {
		int[] arr = {8,9,10,8,7};
//		int[] arr = {2,3,3,4,5,2,1};
		int num = getMinNum(arr);
		
		System.out.println(num);
	}
	
	
	private static int getMinNum(int[] arr){
		int[] help = new int[arr.length]; //创建一个辅助数组

		//分被求出每个位置的糖果个数
		for (int index = 0; index < help.length; index++) {
			help[index] = partion(arr , index);
		}
		
		int su = 0;
		for (int i = 0; i < help.length; i++) {
			su += help[i];
		}
		return su;
	}
	
	//输入一个位置,返回它的糖果个数
	private static int partion(int[] arr,int index) {
		
		int left = 0;	//左侧连续减小的个数
		int right = 0;	//右侧连续减小的个数
		int leftIndex = index-1; //左面的元素
		int rightIndex = index+1;
		while(leftIndex >= 0 && arr[leftIndex] <= arr[leftIndex+1] ){
			if (arr[leftIndex] < arr[leftIndex+1]) { //如果小于就加一,如果等于就不变
				left++;
			}
			leftIndex--;
		}
		
		while(rightIndex < arr.length && arr[rightIndex-1] >= arr[rightIndex] ){
			if (arr[rightIndex-1] > arr[rightIndex]) { //如果小于就加一,如果等于就不变
				right++;
			}
			rightIndex++;
		}
		
		return Math.max(left, right) + 1;
	}
}
