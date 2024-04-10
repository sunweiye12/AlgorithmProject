package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*
����һ�� ���ϸ�������� ������ nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ������ɾ����������³��ȡ�Ԫ�ص� ���˳�� Ӧ�ñ��� һ�� ��Ȼ�󷵻� nums ��ΨһԪ�صĸ�����
���� nums ��ΨһԪ�ص�����Ϊ k ������Ҫ����������ȷ����������Ա�ͨ����
�������� nums ��ʹ nums ��ǰ k ��Ԫ�ذ���ΨһԪ�أ���������������� nums �г��ֵ�˳�����С�nums ������Ԫ���� nums �Ĵ�С����Ҫ��
���� k ��
�����׼:

ϵͳ��������Ĵ���������������:
int[] nums = [...]; // ��������
int[] expectedNums = [...]; // ������ȷ��������
int k = removeDuplicates(nums); // ����
assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
������ж��Զ�ͨ������ô������⽫�� ͨ����

ʾ�� 1��
���룺nums = [1,1,2]
�����2, nums = [1,2,_]
���ͣ�����Ӧ�÷����µĳ��� 2 ������ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2 ������Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2��
���룺nums = [0,0,1,1,1,2,2,3,3,4]
�����5, nums = [0,1,2,3,4]
���ͣ�����Ӧ�÷����µĳ��� 5 �� ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4 ������Ҫ���������г����³��Ⱥ����Ԫ�ء�
*/
public class _03ɾ�����������е��ظ��� {


    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));

        System.out.println("����");

    }

    public int removeDuplicates(int[] nums) {
        int index = 0; //��ǰָ�������λ��
        int cur = 0; //��ǰҪ����ֶε�λ��
        int n = 0; //�Ƴ������ظ����ֵĸ���

        // ���Ǽ������
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        // ��������(����������Ԫ��)
        while (index <= nums.length - 2) { // �����������ڶ���λ�þͺ�
            cur ++;
            while ((index <= nums.length - 2) && (nums[index] == nums[index+1])) {
                index ++;
                n ++;
            }
            if (index == nums.length-1) break;
            nums[cur] = nums[index+1];
            index++;
        }
        return nums.length - n;
    }

}