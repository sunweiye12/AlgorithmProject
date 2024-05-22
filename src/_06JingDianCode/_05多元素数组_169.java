package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*
����һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�

ʾ�� 1��
���룺nums = [3,2,3]
�����3

ʾ�� 2��
���룺nums = [2,2,1,1,1,2,2]
�����2
*/
public class _05��Ԫ������_169 {


    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));

        System.out.println(Arrays.toString(nums));

        System.out.println("����");

    }


    public int majorityElement(int[] nums) {

        int t = nums[0]; // ��ѡԪ��
        int c = 1; // ��ȡƱ��

        for (int i = 1; i < nums.length; i++) {
            if (t == nums[i]) {
                c++;
            } else {
                c--;
                if(c == 0) {
                    t = nums[i+1];
                }
            }
        }
        return t;

    }


}