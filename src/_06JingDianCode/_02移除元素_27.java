package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*
����һ������ nums ��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ���� val ��Ԫ�أ��������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�



˵��:
Ϊʲô������ֵ��������������Ĵ���������?
��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�
����������ڲ���������:

// nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
int len = removeElement(nums, val);

// �ں������޸�����������ڵ������ǿɼ��ġ�
// ������ĺ������صĳ���, �����ӡ�������� �ó��ȷ�Χ�� ������Ԫ�ء�
for (int i = 0; i < len; i++) {
    print(nums[i]);
}


ʾ�� 1��

���룺nums = [3,2,2,3], val = 3
�����2, nums = [2,2]
���ͣ�����Ӧ�÷����µĳ��� 2, ���� nums �е�ǰ����Ԫ�ؾ�Ϊ 2���㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء����磬�������ص��³���Ϊ 2 ���� nums = [2,2,3,3] �� nums = [2,2,0,0]��Ҳ�ᱻ������ȷ�𰸡�
*/
public class _02�Ƴ�Ԫ��_27 {


    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] nums = {1,2,3,0,0,0};
        int val = 3;

        removeElement(nums, val);

        System.out.println(Arrays.toString(nums));

        System.out.println("����");

    }

    public int removeElement(int[] nums, int val) {

        int n = 0;
        int start = 0;
        int end = nums.length -1;

        //�жϿ���������
//        if (nums.length == 0) return 0;

        while (start <= end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                n ++;
                end --;
            } else {
                start ++;
            }
        }

        return nums.length - n;
    }

}