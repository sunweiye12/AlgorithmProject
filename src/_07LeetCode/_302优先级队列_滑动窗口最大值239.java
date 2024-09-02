package _07LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 链接: https://leetcode.cn/problems/sliding-window-maximum/description/
 *  
 *  疑问：窗口的大小是否会比数组到账度大？
 *
 *  思路1：暴力解法，每次对[i - i+k]的这段数据来进行排序将最大值返回。
 *  空间nlogk   时间 n*klogk
 *  优化点：因为只需要找窗口之内的最大元素，因此课可以不用排序，直接遍历一遍就能拿到最大值，最终是 nk 的复杂度
 *
 *  思路2：通过优先队列实现（大头堆）,每次滑动就把下标为 i-k 的位置从堆中移除，然后将i位置的元素添加到堆中，返回堆顶元素
 *
 */

public class _302优先级队列_滑动窗口最大值239 {

    @Test
    public void main() {
        System.out.println("开始");

        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int key = 5;
        int[] ints = maxSlidingWindow(arr, key);
        System.out.println(Arrays.toString(ints)); // 返回 4
    }

    // 思路
//    public int[] maxSlidingWindow2(int[] nums, int k) {
//
//    }



    // 思路2
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }



}