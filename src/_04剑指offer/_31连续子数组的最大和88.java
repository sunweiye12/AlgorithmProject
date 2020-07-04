package _04剑指offer;

import org.junit.Test;

/*
 * 题目:HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 	今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 	当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 	并期望旁边的正数会弥补它呢？
 * 	例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 	给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 *思路:双指针问题解决1.设置两个指针left和right初始位初始位置[0],定义和sum为left到right元素的和(通知定义一个全局的Msum记录最大的sum)
 *		2.每次rigth向右移动一步得到一个新sum,判断sum是否大于零,如果大于0继续向右移动
 *		3.如果sum小于等于0,那就将left和right同时指向right的下一位
 *		4.直到right到达最右端以后,left依次相向右移动,直到最右端结束
 */
public class _31连续子数组的最大和88 {

    @Test
    public void main() {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        int num = FindGreatestSumOfSubArray(arr);
        System.out.println(num);
    }

    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;    //双指针
        int right = 0;
        int sum = arr[0];        //双指针之间的和
        int Msun = arr[0];    //全局最大和
        while (right < arr.length - 1) {
            sum += arr[++right];
            Msun = Math.max(sum, Msun);
            if (sum <= 0 && right < arr.length - 1) { //判断不可越界
                sum = arr[++right];
                Msun = Math.max(sum, Msun);
                left = right;
            }
        }
        //当right到达最右边时
        while (left < arr.length - 1) {
            sum -= arr[++left];
            Msun = Math.max(sum, Msun);
        }
        return Msun;
    }
}
