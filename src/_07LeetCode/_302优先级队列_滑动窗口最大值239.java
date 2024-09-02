package _07LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * ����: https://leetcode.cn/problems/sliding-window-maximum/description/
 *  
 *  ���ʣ����ڵĴ�С�Ƿ������鵽�˶ȴ�
 *
 *  ˼·1�������ⷨ��ÿ�ζ�[i - i+k]����������������������ֵ���ء�
 *  �ռ�nlogk   ʱ�� n*klogk
 *  �Ż��㣺��Ϊֻ��Ҫ�Ҵ���֮�ڵ����Ԫ�أ���˿ο��Բ�������ֱ�ӱ���һ������õ����ֵ�������� nk �ĸ��Ӷ�
 *
 *  ˼·2��ͨ�����ȶ���ʵ�֣���ͷ�ѣ�,ÿ�λ����Ͱ��±�Ϊ i-k ��λ�ôӶ����Ƴ���Ȼ��iλ�õ�Ԫ����ӵ����У����ضѶ�Ԫ��
 *
 */

public class _302���ȼ�����_�����������ֵ239 {

    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int key = 5;
        int[] ints = maxSlidingWindow(arr, key);
        System.out.println(Arrays.toString(ints)); // ���� 4
    }

    // ˼·
//    public int[] maxSlidingWindow2(int[] nums, int k) {
//
//    }



    // ˼·2
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