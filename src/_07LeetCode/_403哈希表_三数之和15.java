package _07LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * ����: https://leetcode.cn/problems/3sum/description/
 *  
 *  ���ʣ����û�з��ϵĽ��ֱ�ӷ���һ�������飿
 *  ����ĳ������� >= 3
 *  ��Ҫ������ϣ��Ҳ�����˳�򣬲��ظ���
 *  �������ظ���
 *
 *
 * ˼·1�������ⷨ
 *  �����±꣬i��j��p�����α���
 *  i = 0��length
 *  j = i+1,length
 *  p = j+1,length
 *  �����Ͻ������������Ȼ���á�����ƴ���������ŵ�set�У����set�е�Ԫ�طֱ��ó����� ��-�� �и�����ص�����С�
 *
 *  ʱ�为��� O(n3)  �ռ�O(n)
 **
 *  ˼·2������������֮�͡��ľ��飬���������ѵ���Ҫ�������Ҳ��ظ��Ľ⡣
 *  ��˵�һ���ֽ���������Ȼ������ұ�����
 *  ÿ�α�����һ����֮�� �������������ݾ;��� ����֮�͵����⣬���������������������֮��ģ�����Ҫ���н⡣
 *  Ҳ��˿���ͨ��˫ָ�����⣺
 *  start��ʼ��ͷ
 *  end��ʼ����β��
 *  �������֮��С��Ŀ��ֵ��start���ƶ���
 *  ����Ŀ��ֵ��end���ƶ���������������ֱ��start��end������
 *
 *  O(n2)
 *
 *
 */

public class _403��ϣ��_����֮��15 {

    @Test
    public void main() {
        System.out.println("��ʼ");
        int[] arr = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> res = threeSum(arr);
        System.out.println(res);
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }

        // ����
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];

            // ˫ָ������������֮�͵����д�
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {

                if (nums[start] + nums[end] > target) {
                    end--;
                    continue;
                }
                if (nums[start] + nums[end] < target) {
                    start++;
                    continue;
                }
                if (nums[start] + nums[end] == target) {
                    ArrayList<Integer> listTmp = new ArrayList<>();
                    listTmp.add(nums[i]);
                    listTmp.add(nums[start]);
                    listTmp.add(nums[end]);
                    list.add(listTmp);
                    //������ͬ��Ԫ�ص����һ��
                    while (start+1 < nums.length && nums[start] == nums[start+1]) {
                        start++;
                    }
                    start++;
                }
            }
            //������ͬ��Ԫ�ص����һ��
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return list;
    }


}