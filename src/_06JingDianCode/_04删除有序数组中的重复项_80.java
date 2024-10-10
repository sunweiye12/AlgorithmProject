package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*

����һ���������� nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ�ó��ִ����������ε�Ԫ��ֻ�������� ������ɾ����������³��ȡ�
��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�

ʾ�� 1��
���룺nums = [1,1,1,2,2,3]
�����5, nums = [1,1,2,2,3]
���ͣ�����Ӧ�����³��� length = 5, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 1, 1, 2, 2, 3�� ����Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2��
���룺nums = [0,0,1,1,1,1,2,3,3]
�����7, nums = [0,0,1,1,2,3,3]
���ͣ�����Ӧ�����³��� length = 7, ����ԭ�����ǰ���Ԫ�ر��޸�Ϊ 0, 0, 1, 1, 2, 3, 3������Ҫ���������г����³��Ⱥ����Ԫ�ء�
*/
public class _04ɾ�����������е��ظ���_80 {


    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] nums = {0,0,1,1,1,1,2,3,3};

        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));

        System.out.println("����");

    }

    // {0,0,1,1,1,1,2,3,3};
    // {0,0,1,1,2,3,3   ,3,3};
    public int removeDuplicates(int[] nums) {
        int index = 0; //��ǰָ�������λ��
        int cur = 0; //��ǰҪ����ֶε�λ��
        int n = 0; //�Ƴ������ظ����ֵĸ���
        int flag = 1; //ÿ���ظ����ֵĸ���,�ж������ǲ��ǰ���2��������Ԫ��

        // ���Ǽ������
        if (nums.length <= 0) return nums.length;

        // ��������(����������Ԫ��)
        while (index <= nums.length - 2) { // �����������ڶ���λ�þͿ���

            while ((index <= nums.length - 2) && (nums[index] == nums[index+1])) {
                index ++;
                flag ++; // ˵���ж��Ԫ��
                if (flag > 2) {
                    n ++;
                }
            }


            // ���û�е�ͷ
            if (flag > 1) {
                nums[cur] = nums[index];
                nums[cur+1] = nums[index];
                cur = cur + 2;
            } else {
                nums[cur] = nums[index];
                cur ++;
            }
            index ++;
            flag = 1;

            // ���ж��ǲ��ǵ�ͷ��
            if (index == nums.length-1) {
                nums[cur] = nums[index];
            }

        }
        return nums.length - n;
    }

}