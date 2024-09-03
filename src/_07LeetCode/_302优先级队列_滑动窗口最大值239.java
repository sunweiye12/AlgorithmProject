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
 *  空间nlogk   时间 n * klogk
 *  优化点：因为只需要找窗口之内的最大元素，因此可以不用排序，直接遍历一遍就能拿到最大值，最终是 nk 的复杂度
 *
 *  思路2：通过优先队列实现（大头堆）,每次滑动就把下标为 i-k 的位置从堆中移除，然后将i位置的元素添加到堆中，返回堆顶元素
 *  优化点：优先队列的元素带有其原来的下标（元素设置成两维度，重新compare函数），这样每次新元素只需要push到队列中，
 *          选最大值的时候只需要判断堆顶的元素下标是否在出口内就可
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
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = getMax(nums, i, i + k - 1);
        }
        return ret;
    }

    private int getMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }



    // 思路2
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];

        // 创建一个优先队列并且，重构其compare方法
        // 元素是一个数组，但是其只有两个下标。第一个下标代表其值，第二个下标代表其index
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0]; //  大数在顶
            }
        });

        // 将前k个元素添加到队列中
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        // 获取要返回的第一个元素
        ret[0] = pq.peek()[0];
        //将剩余的元素以此添加到队列中，并且每一次添加都获取一个有效的最大值
        for (int i = k; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= (i-k)) {
                pq.poll();
            }
            ret[i-k+1] = pq.peek()[0];
        }
        return ret;
    }
}