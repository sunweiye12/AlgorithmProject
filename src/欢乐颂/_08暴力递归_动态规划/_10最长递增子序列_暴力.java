package 欢乐颂._08暴力递归_动态规划;
/*
 * 题目:给定你一个数组,然后你输出此数组的最长递增子序列的长度
 */
public class _10最长递增子序列_暴力 {
		  
	public static void main(String [] args){
		int [] randArr = new int[]{5,2,8,6,3,6,9,7};
		maxAscLen(randArr);
	}
	
    public static void maxAscLen(int [] arr){
        int n = arr.length;
        int [] dp = new int[n];			//保存以元素i结尾的递增子序列长度
        int [][] lensArr = new int[n][n];	//保存以每个元素i结尾的递增子序列
        for(int i = 0; i <= n - 1; i++){	//初始化辅助空间
        	dp[i] = 1;
            lensArr[i][0] = arr[i];
        }
       
        for(int i = 0; i < n; i++){
           for(int j = 0; j < i; j++){	//查找i之前的元素
             if(arr[j] < arr[i] && dp[j] + 1 > dp[i]){
            	 dp[i] = dp[j] + 1;		//更新以元素i结尾的最长递增子序列长度
            	 //把以元素j结尾的最长递增子序列拷贝到以元素i结尾的最长递增子序列中
                 for(int k = 0; k <= dp[j]; k++){	
                     lensArr[i][k] = lensArr[j][k];  
                 }
                 //然后在添加上第i个元素元素
                 lensArr[i][dp[i] - 1] = arr[i]; 
              }
           }
       }
        //寻找最大递增子序列长度的元素下标
        //这里只能找到第一个最长递增子序列的下标，例如本例中的最长子序列分别为{2，3，6，9}，{2，3，6，7}
        //也即这里只能返回9的下标
        int index = 0;
        for(int i = 0; i <= n - 1; i++){
           if(dp[index] < dp[i]){
             index = i;
          }
        }
        //这里只能输出一个最长递增子序列
        System.out.println("最大递增子序列长度：" + dp[index]);
        System.out.print("最大递增子序列为：");
        for(int i = 0; i < dp[index]; i++){
        	System.out.print(lensArr[index][i] + " ");
        }
        System.out.println();
    }
}
