package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*
���������� �ǵݼ�˳�� ���е��������� nums1 �� nums2�������������� m �� n ���ֱ��ʾ nums1 �� nums2 �е�Ԫ����Ŀ��
���� �ϲ� nums2 �� nums1 �У�ʹ�ϲ��������ͬ���� �ǵݼ�˳�� ���С�
ע�⣺���գ��ϲ������鲻Ӧ�ɺ������أ����Ǵ洢������ nums1 �С�Ϊ��Ӧ�����������nums1 �ĳ�ʼ����Ϊ m + n������ǰ m ��Ԫ�ر�ʾӦ�ϲ���Ԫ�أ��� n ��Ԫ��Ϊ 0 ��Ӧ���ԡ�nums2 �ĳ���Ϊ n ��

ʾ�� 1��
���룺nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
�����[1,2,2,3,5,6]
���ͣ���Ҫ�ϲ� [1,2,3] �� [2,5,6] ��
�ϲ������ [1,2,2,3,5,6] ������б��Ӵֱ�ע��Ϊ nums1 �е�Ԫ�ء�
*/
public class _01�ϲ�������������_88 {


    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println("����");

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;

        int p = m + n -1;

        while ((p1 >= 0) && (p2 >= 0)) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
                nums1[p--] = nums2[p2--];
            }
        }
        while (p1 >= 0) nums1[p--] = nums1[p1--];
        while (p2 >= 0) nums1[p--] = nums2[p2--];

        System.out.println(Arrays.toString(nums1));

    }

}