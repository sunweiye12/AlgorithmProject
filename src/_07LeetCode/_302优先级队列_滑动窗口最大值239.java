package _07LeetCode;

import org.junit.Test;

import java.util.*;


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
 *     空间 n  时间 n * logn
 *
 *   思路三：单调队列
 *    想象一架飞机穿过一坐坐高山，每翻过一个山头，都标记出最高的山峰的高度。
 *    我们需要一个队列来保存我们视野内的山，这个队列应该保证是单调递减的顺序，每次视野内中最大的山，就是队列最头的位置就是（如果头的位置是在视野内的话）。
 *    注意：我们需要往队尾添加（删除）数据，从队头删除数据，因此需要一个双端队列，且队列中的元素是从大到小的，符合性质的双端队列 -> 称为单调队列
 *    那如何构建这个队列？
 *    首先初始化的时候先构造一个队列，然后将前k个元素依次往队列里面塞，塞入的时候，如果队列为空，则直接塞入队列，否则拿到队列尾部的元素，和i元素判断大小，如果i元素小，我们就将其放到队尾。
 *      如果i元素大，则将队尾元素去除掉(目的是把左侧比自己小的数据都删除掉，这样能保证队列中数据是递减的)，然后在做以上的判断。最后前K和元素都处理完以后，队首的元素就是，看到的第一个高山。
 *
 *     后续k之后的元素在塞入队列的时候依然保持上面的原则，往队尾插入，但是在判断高山的时候，需要拿到队首的元素，并且判断队首的元素是否已经离开了视野，直到从队首拿到视野内的元素。
 *
 */

public class _302优先级队列_滑动窗口最大值239 {

    @Test
    public void main() {
        System.out.println("开始");

        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int key = 5;
        int[] ints = maxSlidingWindow3(arr, key);
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

    // 思路三
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        ans[0] = nums[deque.peekFirst()];

        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }

        return ans;
    }
}