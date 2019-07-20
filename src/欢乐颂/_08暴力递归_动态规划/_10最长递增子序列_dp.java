package 欢乐颂._08暴力递归_动态规划;
/*
 * 题目:给定你一个数组,然后你输出此数组的最长递增子序列的长度
 * 
 * 思路:DP解法,创建一个dp[]数组  其中dp[i]代表以下标为i的元素结尾的最长递增子序列的个数
 * 		1.dp[i] = 1,因为以第一个数字结尾的子序列只有一个-->此处默认任何数组数字结尾的长度都为1
 * 		2.dp[i] 为一下标为i结尾的递增子序列长度,则可以通过找到i前面,并满足arr[j] < arr[i]的j,然后最大的dp[j]加1得到dp[i]
 * 		3.上面的语义为,可以找到i指向元素之前,比i元素小,最大的子序列.加1
 * 		4.最后输出以每个字符结尾中最长的递增序列
 */
public class _10最长递增子序列_dp {
		  
	public static void main(String [] args){
		int [] randArr = new int[]{5,2,8,6,3,6,9,7};
		int len = maxAscLen(randArr);
		System.out.println(len);
	}
	
    public static int maxAscLen(int [] arr){
    	//basecase
    	if (arr == null || arr.length == 0) {
			return 0;
		}
    	//创建dp数组  dp[i]代表以下标为i的元素结尾的最长递增子序列的个数
    	int[] dp = new int[arr.length];
    	//初始化每个元素结尾的默认只有一个
    	for (int i = 0; i < dp.length; i++) {
    		dp[i] = 1;
		}
    	for (int i = 1; i < dp.length; i++) {
    		for (int j = 0; j < i; j++) { //查找i以前,满足arr[j]<arr[i],的j元素中dp[j]最大的
    			if (arr[j] < arr[i]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
    	//找到最长的
    	int ret = 1;//最小为1
    	for (int i : dp) {
			ret = Math.max(ret, i);
		}
        return ret;
    }
}
