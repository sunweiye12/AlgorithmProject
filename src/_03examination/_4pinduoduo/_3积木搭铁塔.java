package _03examination._4pinduoduo;
/*
 * 题意:有一系列积木长宽为Li 高为1,我们利用这些积木来搭建一个高塔
 * 		1.要求每一层只能有一个积木,并且上面的积木要比下面的积木面颊也要小
 * 		2.每一个积木有自己的重量Wi,每一个积木上方所能承受的重量不能超过自身重量的7倍
 * 提供给你第i个积木长宽为Li[i].重量为Wi[i]
 * 输出可以搭出来的最高塔层数
 * 
 * 思路:利用动态规划来解题
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
		//创建dp数组 dp[i]就代表前i+1个方块时的最大高度
		int[] dp = new int[li.length];
		//初始化,当只有一个元素时,他的高度就为1
		dp[0] = 1;
		//状态转换
		for (int x = 1; x < dp.length; x++) {
			if(li[x] > li[x-1]){ //只有下一个元素比自己大才考虑是否加上他
				//调用函数获取x值上所有积木的重量
				int temWi = getWiget(wi, x); 
				//如果重量达标则可以将x积木添加进来,否则的话则不行
				if (temWi <= wi[x]*7) {
					dp[x] = dp[x-1] + 1;
				} else{
					//找到0-x找出一个抛弃(将质量记为0)
					removeOne(wi,x); //调用方法
					dp[x] = dp[x-1];
				}
			} else{	//如果下一个元素和自己想同大小则考虑(两者选一个)
				dp[x] = dp[x-1];
				if(wi[x] < wi[x-1]){ //如果下一个比自己重的话果断抛弃,如果比自己轻的话考虑一下
					int temWi = getWiget(wi, x-1);
					if (temWi <= wi[x]*7) {
						wi[x-1] = 0;
					}
				} else{
					wi[x] = 0;
				}
			}
		}
		System.out.print(dp[dp.length-1]);
	}
	
	//找到0-x中找出一个来抛出,原则为找出一个最重的抛弃,如果最重的不是第x个元素时还要判断抛弃之后x上面的元素是否会超标
	//如若超标,则只能放弃x积木
	private static void removeOne(int[] wi, int x) {
		//得到最重的下标为index
		int index = 0;
		for (int i = 0; i <= x; i++) {
			if (wi[i] > wi[index]) {
				index = i;
			}
		}
		//如果index不是x则需要判断一下,去除index后是否还会超标
		if (index == x) {
			wi[index] = 0;
		} else{
			int temWi = getWiget(wi, x);
			//如果index去除后符合条件则去除,否则去除x位置
			if (temWi - wi[index] <= wi[x]*7) {
				wi[index] = 0;
			} else {
				wi[x] = 0;
			}
		}
	}

	//获取x之上的积木的重量
	private static int getWiget(int[] wi, int x) {
		int temWi = 0;
		for (int i = 0; i < x; i++) {
			temWi += wi[i];
		}
		return temWi;
	}
	//选择排序(arr按照从小到大的顺序排序,同时arr1对应的位置也同时调整)
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
