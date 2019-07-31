package _4pinduoduo;
/*
 * 题意:有一系列积木长宽为Li 高为1,我们利用这些积木来搭建一个高塔
 * 		1.要求每一层只能有一个积木,并且上面的积木要比下面的积木面颊也要小
 * 		2.每一个积木有自己的重量Wi,每一个积木上方所能承受的重量不能超过自身重量的7倍
 * 提供给你第i个积木长宽为Li[i].重量为Wi[i]
 * 输出可以搭出来的最高塔层数
 */
public class _3积木搭铁塔 {
	public static void main(String[] args) {
		int[] Li = {1,2,3,4,5,6,7,8,9,10};
		int[] Wi = {1,1,1,1,1,1,1,1,1,10};
		//按照边长由小到大进行排序(注意对应的重量也要交换)
		selectSort(Li,Wi);
		//动态规划解题
		partion(Li,Wi);
	}
	
	//动态规划法
	private static void partion(int[] li, int[] wi) {
		//basecase
		if (li.length <= 1 || wi.length <= 1) {
			System.out.println(li.length);
			return;
		}
		//创建dp数组 dp[i]就代表前i个方块时的最大高度
		int[] dp = new int[li.length];
		//初始化,当只有一个元素时,他的高度就为1
		dp[0] = 1;
		//状态转换
		for (int x = 1; x < dp.length; x++) {
			if(li[x] > li[x-1]){
				//用来计算x之前的重量
				int temWi = 0;
				for (int i = 0; i < x; i++) {
					temWi += wi[i];
				}
				//如果重量达标则可以将x积木添加进来,否则的话则不行
				if (temWi <= wi[x]*7) {
					dp[x] = dp[x-1] + 1;
				} else{
					//找到0-x中最重的一个抛弃(将质量记为0)
					partion1(wi,x);
					dp[x] = dp[x-1];
				}
			} else{
				wi[x] = 0;
				dp[x] = dp[x-1];
			}
		}
		System.out.print(dp[dp.length-1]);
	}
	
	//找到0-x中最重的一个置为0
	private static void partion1(int[] wi, int x) {
		int tem = 0;
		for (int i = 0; i <= x; i++) {
			if (wi[i] > wi[tem]) {
				tem = i;
			}
		}
		wi[tem] = 0;
	}

	//选择排序
	public static void selectSort(int[] arr,int[] arr1){
		for(int i = 0;i < arr.length-1; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i]>arr[j]){
					swap(arr,i,j);
					swap(arr1,i,j);
				}
			}
		}
	}
	private static void swap(int[] arr,int i, int j) {
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
}
