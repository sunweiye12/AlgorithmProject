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
 *  �ռ�nlogk   ʱ�� n * klogk
 *  �Ż��㣺��Ϊֻ��Ҫ�Ҵ���֮�ڵ����Ԫ�أ���˿��Բ�������ֱ�ӱ���һ������õ����ֵ�������� nk �ĸ��Ӷ�
 *
 *  ˼·2��ͨ�����ȶ���ʵ�֣���ͷ�ѣ�,ÿ�λ����Ͱ��±�Ϊ i-k ��λ�ôӶ����Ƴ���Ȼ��iλ�õ�Ԫ����ӵ����У����ضѶ�Ԫ��
 *  �Ż��㣺���ȶ��е�Ԫ�ش�����ԭ�����±꣨Ԫ�����ó���ά�ȣ�����compare������������ÿ����Ԫ��ֻ��Ҫpush�������У�
 *          ѡ���ֵ��ʱ��ֻ��Ҫ�ж϶Ѷ���Ԫ���±��Ƿ��ڳ����ھͿ�
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



    // ˼·2
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k + 1];

        // ����һ�����ȶ��в��ң��ع���compare����
        // Ԫ����һ�����飬������ֻ�������±ꡣ��һ���±������ֵ���ڶ����±������index
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0]; //  �����ڶ�
            }
        });

        // ��ǰk��Ԫ����ӵ�������
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        // ��ȡҪ���صĵ�һ��Ԫ��
        ret[0] = pq.peek()[0];
        //��ʣ���Ԫ���Դ���ӵ������У�����ÿһ����Ӷ���ȡһ����Ч�����ֵ
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