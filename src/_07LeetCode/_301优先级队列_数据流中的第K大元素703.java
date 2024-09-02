package _07LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 链接:https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/
 *  
 *  疑问：如果出事数组的长度为4，但是k为10，之后插入过程中，如何获取到第k大的元素（不足10个元素的时候应该返回什么）
 *
 *  思路1:创建一个长度为k的数组，在数据流中的个数小于k的时候每次都插入到数组的空位中，直到数组插满。
 *      当数据满的时候，再插入元素的时候，先对数组进行排序，判断最小的元素，是否比要插入的元素大，
 *      如果排序后最小的元素比插入元素大，则直接跳过。
 *      否则将其放到最小元素的位置上。
 
 *      复杂度：时间插入O(n * kLogk)，返回O(1)， 空间O(n)
 *      
 *  思路2：借助优先级队列的特性，维护一个长度为k的小顶怼（mini-heap）,每次插入元素的时候判断，堆顶元素是否比插入元素大，
 *      如果大则直接跳过返回堆顶
 *      否则堆顶出，将新元素插入到堆中，然后返回新堆顶
 *      时间复杂度： O(N * logk)
 *
 */

public class _301优先级队列_数据流中的第K大元素703 {

    @Test
    public void main() {
        System.out.println("开始");
        int[] tem = new int[]{5, -1};
        KthLargest kthLargest = new KthLargest(3, tem);
        System.out.println(kthLargest.add(2)); // 返回 4
        System.out.println(kthLargest.add(1)); // 返回 5
        System.out.println(kthLargest.add(-1)); // 返回 5
        System.out.println(kthLargest.add(3)); // 返回 8
        System.out.println(kthLargest.add(4)); // 返回 8

    }

    // 思路2
    class KthLargest {

        //
        private PriorityQueue<Integer> miniHeap;
        private int size;
        public KthLargest(int k, int[] nums) {
            miniHeap = new PriorityQueue<>(k);
            size = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (miniHeap.size() < size) {
                miniHeap.offer(val);
            } else if (miniHeap.peek() < val) {
                miniHeap.poll();
                miniHeap.offer(val);
            }
            return miniHeap.peek();
        }
    }

    // 思路1
    class KthLargest1 {

        private int[] topK;
        private int index = 0;

        public KthLargest1(int k, int[] nums) {
            // 初始化
            topK = new int[k];
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            // 队列没有满
            if (index < topK.length) {
                topK[index] = val;
                index++;
                fastSort(topK, 0, index-1);
                return topK[index-1];
            }

            if (topK[topK.length-1] < val) {
                topK[topK.length-1] = val;
                fastSort(topK, 0, topK.length-1);
            }
            return topK[topK.length-1];
        }

        // 快排->从大到小 (这里一定要制定能指定排序的下标)
        private void fastSort (int[] arr,int first,int last){
            if (first >= last) { //递归截止的条件(当数组只有一个元素)
                return;
            }

            int mid_value = arr[first];	//取第一个元素作为基准元素用作比较。
            int low = first;
            int high = last;

            while (low < high) {
                //当满足条件是游标左移,否则交换
                while((low < high) && (arr[high]<=mid_value)){
                    high -= 1;
                }
                arr[low] = arr[high];

                //当满足条件时游标右移,否则交换
                while((low < high) && (arr[low]>=mid_value)){
                    low += 1;
                }
                arr[high] = arr[low];
            }

            //从循环中退出意味着low = high,两个指针相遇
            arr[low] = mid_value;
            //通过递归将左右两侧进行快排
            fastSort(arr,first,low-1);
            fastSort(arr,low+1,last);
        }

        // 从小到大排序
        private void fastSort (int[] arr) {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length/2; i++) {
                arr[i] = arr[i]^arr[arr.length-1-i];
                arr[arr.length-1-i] = arr[i]^arr[arr.length-1-i];
                arr[i] = arr[i]^arr[arr.length-1-i];
            }
        }
    }



}