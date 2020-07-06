package _05LeetCode;

import org.junit.Test;

/*
给定两个大小为 m 和 n 的正序（从小到大）数组?nums1 和?nums2。
请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为?O(log(m + n))。
你可以假设?nums1?和?nums2?不会同时为空。

暴力:
1.将连个数组合并成一个数组,排序后获取中位数  O((m+n)log(m+n))

2.merge:归并排序中的merge

3.通过二分查找来实现

*/
public class _04两个有序数组的中位数 {

    @Test
    public void main( ) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double ret = findMedianSortedArrays(nums1,nums2);
        double ret1 = SortedArrays(nums1,nums2);
        System.out.println(ret);
        System.out.println(ret1);
    }

    // 二分查找
    public double SortedArrays(int[] nums1, int[] nums2) {
        //让num1变为比较短的数组
        if (nums1.length > nums2.length) {
            int[] tem = nums1;
            nums1 = nums2;
            nums2 = tem;
        }
        int m = nums1.length;
        int n = nums2.length;
        //过去中位线左侧元素的个数
        int totallLeft = m + (n - m + 1) / 2;   //  (m+n+1)/2  1.对于偶数奇数取值相同结果   2.防止数值溢出

        // 在nums1中寻找nums1中位线分割线的位置[0 m]中
        // 使得nums1[i - 1] <= nums2[j]  && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totallLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索[left i-1]
                right = i - 1;
            } else {
                // 下一轮搜索[i right]
                left = i;
            }
        }

        int i = left;
        int j = totallLeft - i;
        int nums1LeftMax = i == 0? Integer.MIN_VALUE : nums1[i-1];
        int nums1RightMin = i == m? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0? Integer.MIN_VALUE : nums2[j-1];
        int nums2RightMin = j == n? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        } else {
            return (double) (Math.max(nums1LeftMax,nums2LeftMax) + Math.min(nums1RightMin,nums2RightMin))/2;
        }
    }

    // merge   (时间空间都是 O(m+n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tem = new int[nums1.length + nums2.length];
        int index = 0;
        int d1 = 0;
        int d2 = 0;
        while (d1 < nums1.length && d2 < nums2.length) {        // 边界问题
            tem[index++] = (nums1[d1] <= nums2[d2]) ? nums1[d1++] : nums2[d2++];
        }
        while(d1 < nums1.length) {
            tem[index++] = nums1[d1++];
        }
        while(d2 < nums2.length) {
            tem[index++] = nums2[d2++];
        }
        if (tem.length % 2 == 0) {
            return (double)(tem[tem.length/2] + tem[tem.length/2 -1]) / 2;      // 会不会越界
        } else {
            return tem[tem.length/2];
        }
    }
}
