package _07LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * ����:https://leetcode.cn/problems/two-sum/description/
 *  
 *  ���ʣ������������������ϵ�Ԫ�أ�
 *       �Ƿ�һ��������Ԫ�ؿ��Դճ����� num������ղ������Ļ��������ô���أ�
 *       �������������Ƿ�����������ͬ��Ԫ��--����ʹ��������ͬ��Ԫ�أ����������п��ܻ������ֵͬ��Ԫ�ء�
 *
 *  ˼·1������������������������鿴���ս�����Ҫ�������Ԫ���±귵�ء�
 *         ʱ�� O(n2) �ռ� O(n)
 *
 *  ˼·2��ͨ��һ��hashMap�ṹ���Ż���ʱ�临�Ӷȣ��������е�Ԫ�ض��ŵ�һ��hashMap�У�kayΪֻ��valueΪ���±ꡣȻ�����α���
 *        sum[i]��hashMap���Ƴ������ж� num - sum��i�� �Ƿ���map�д��ڣ�������ھͷ�������Ԫ�ص� index
 *
 */

public class _402��ϣ��_����֮��2 {

    @Test
    public void main() {
        System.out.println("��ʼ");

        int[] arr = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum2(arr,9))); // ���� 4
    }

    // ˼·1
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {

            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) return new int[]{i, j};
            }

        }
        return new int[]{0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && nums[i]*2 == target)
                return new int[]{map.get(nums[i]), i};
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            map.remove(nums[i]);
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
        }
        return new int[]{0, 0};
    }


    // ˼·2 ����д��
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

}