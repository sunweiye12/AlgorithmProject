package _07LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * ����:https://leetcode.cn/problems/kth-largest-element-in-a-stream/description/
 *  
 *  ���ʣ������������ĳ���Ϊ4������kΪ10��֮���������У���λ�ȡ����k���Ԫ�أ�����10��Ԫ�ص�ʱ��Ӧ�÷���ʲô��
 *
 *  ˼·1:����һ������Ϊk�����飬���������еĸ���С��k��ʱ��ÿ�ζ����뵽����Ŀ�λ�У�ֱ�����������
 *      ����������ʱ���ٲ���Ԫ�ص�ʱ���ȶ�������������ж���С��Ԫ�أ��Ƿ��Ҫ�����Ԫ�ش�
 *      ����������С��Ԫ�رȲ���Ԫ�ش���ֱ��������
 *      ������ŵ���СԪ�ص�λ���ϡ�
 
 *      ���Ӷȣ�ʱ�����O(n * kLogk)������O(1)�� �ռ�O(n)
 *      
 *  ˼·2���������ȼ����е����ԣ�ά��һ������Ϊk��С����mini-heap��,ÿ�β���Ԫ�ص�ʱ���жϣ��Ѷ�Ԫ���Ƿ�Ȳ���Ԫ�ش�
 *      �������ֱ���������ضѶ�
 *      ����Ѷ���������Ԫ�ز��뵽���У�Ȼ�󷵻��¶Ѷ�
 *      ʱ�临�Ӷȣ� O(N * logk)
 *
 */

public class _301���ȼ�����_�������еĵ�K��Ԫ��703 {

    @Test
    public void main() {
        System.out.println("��ʼ");
        int[] tem = new int[]{5, -1};
        KthLargest kthLargest = new KthLargest(3, tem);
        System.out.println(kthLargest.add(2)); // ���� 4
        System.out.println(kthLargest.add(1)); // ���� 5
        System.out.println(kthLargest.add(-1)); // ���� 5
        System.out.println(kthLargest.add(3)); // ���� 8
        System.out.println(kthLargest.add(4)); // ���� 8

    }

    // ˼·2
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

    // ˼·1
    class KthLargest1 {

        private int[] topK;
        private int index = 0;

        public KthLargest1(int k, int[] nums) {
            // ��ʼ��
            topK = new int[k];
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            // ����û����
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

        // ����->�Ӵ�С (����һ��Ҫ�ƶ���ָ��������±�)
        private void fastSort (int[] arr,int first,int last){
            if (first >= last) { //�ݹ��ֹ������(������ֻ��һ��Ԫ��)
                return;
            }

            int mid_value = arr[first];	//ȡ��һ��Ԫ����Ϊ��׼Ԫ�������Ƚϡ�
            int low = first;
            int high = last;

            while (low < high) {
                //�������������α�����,���򽻻�
                while((low < high) && (arr[high]<=mid_value)){
                    high -= 1;
                }
                arr[low] = arr[high];

                //����������ʱ�α�����,���򽻻�
                while((low < high) && (arr[low]>=mid_value)){
                    low += 1;
                }
                arr[high] = arr[low];
            }

            //��ѭ�����˳���ζ��low = high,����ָ������
            arr[low] = mid_value;
            //ͨ���ݹ齫����������п���
            fastSort(arr,first,low-1);
            fastSort(arr,low+1,last);
        }

        // ��С��������
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