package _1bytedance;
import java.util.*;
/*
 * 题目:小明的大学搬迁到了新校区，新校区的所有道路都是纵横交错，组成了一个棋盘网格。
 * 他每天要在宿舍与教学楼之间往返，而宿舍与教学楼恰好位于一个n乘n的正方形网格的对角线的两端，
 * 那么他不穿越（但可以碰到）对角线用最短的路程从宿舍走到教学楼，有几种走法？
 *  输入  3   输出  5
 * 思路:dp思想来做和_10题类似
 */
public class _12上学之路{
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = Integer.parseInt(in.nextLine());
         int[][] arr = new int[n+1][n+1];
         for(int i = 0; i < arr.length ; i++){
             arr[0][i] = 1;
             arr[i][0] = 1;
         }
         for(int i = 1;i < arr.length ; i++){
             for(int j = 1;j < arr.length ; j++){
                 if(i == j){
                     arr[i][j] = arr[i][j-1];
                 } else{
                     arr[i][j] = arr[i][j-1] + arr[i-1][j];
                 }
             }
         }
         System.out.println(arr[n][n]);
     }
}
