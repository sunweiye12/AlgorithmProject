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
        int [] lens = new int[n];	//保存以元素i结尾的递增子序列长度
        int [][] lensArr = new int[n][n];	//保存以每个元素i结尾的递增子序列
        for(int i = 0; i <= n - 1; i++){	//初始化辅助空间
        	lens[i] = 1;
            lensArr[i][0] = arr[i];
        }
       
        for(int i = 0; i < n; i++){
           for(int j = i - 1; j >= 0; j--){	//从后往前寻找
             if(arr[i] > arr[j] && lens[j] + 1 > lens[i]){
            	 lens[i] = lens[j] + 1;	//更新以元素i结尾的最长递增子序列长度
                 for(int k = 0; k <= lens[j]; k++){	//把以元素j结尾的最长递增子序列拷贝到以元素i结尾的最长递增子序列中
                     lensArr[i][k] = lensArr[j][k];
                 }
                 lensArr[i][lens[i] - 1] = arr[i];
              }
           }
       }
        //寻找最大递增子序列长度的元素下标
        //这里只能找到第一个最长递增子序列的下标，例如本例中的最长子序列分别为{2，3，6，9}，{2，3，6，7}
        //也即这里只能返回9的下标
        int index = 0;
        for(int i = 0; i <= n - 1; i++){
           if(lens[index] < lens[i]){
             index = i;
          }
        }
        //这里只能输出一个最长递增子序列
        System.out.println("最大递增子序列长度：" + lens[index]);
        System.out.print("最大递增子序列为：");
        for(int i = 0; i < lens[index]; i++){
        	System.out.print(lensArr[index][i] + " ");
        }
        System.out.println();
    }
}
