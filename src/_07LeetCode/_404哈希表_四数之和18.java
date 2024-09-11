package _07LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * ����: https://leetcode.cn/problems/4sum/description/
 *  
 *  ���ʣ�����Ҫ��4�������ϵ�Ԫ�أ�Ҫ��Ȼ����һ�������飿
 *       ����Խ������,����int��ӻ��������ʱ��Ҫ���� �Ƿ��Խ��
 *  1. Ҫ���п��ܵĽ�
 *  2. ����в������ظ�����Ԫ��
 *
 *  ˼·����Ϊ�������ظ���Ԫ�أ����Ե�һ�������Ƕ������������ O(nlogn)
 *  Ȼ�����α���ÿһ��Ԫ�أ�������֮��ʣ�µ����������������ӵ�����o(n2)���������������ʱ�临�Ӷ���n(n3)
 */

public class _404��ϣ��_����֮��18 {

    @Test
    public void main() {
        System.out.println("��ʼ");
        int[] arr = new int[]{1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> res = fourSum(arr, -294967296);
        System.out.println(res);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < nums.length-3; i++) {
            // ת����������ӵ�����
            // ���±�Ϊi+1��β����λ���У��ҵ����Ϊtarget-num[i]���������� --���˴�����Ҫȥ�أ����к���ͳһ���ǣ�
            List<String> threeNums = getThreeNums(i + 1, nums, target-nums[i]);
            for (String tmp : threeNums) {
                set.add(nums[i]+"_"+tmp);
            }
        }

        for (String tmp : set) {
            String[] s = tmp.split("_");
            ArrayList<Integer> listTmp = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                listTmp.add(Integer.parseInt(s[i]));
            }
            list.add(listTmp);
        }

        return list;
    }

    private List<String> getThreeNums(int index, int[] nums, int targetTmp) {
        List<String> list = new ArrayList<>();

        for (int i = index; i < nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            while (start<end) {
                if ((long)nums[start]+nums[end]+nums[i] > targetTmp) {
                    end--;
                    continue;
                }
                if ((long)nums[start]+nums[end]+nums[i] < targetTmp ) {
                    start++;
                    continue;
                }
                if ((long)nums[start]+nums[end]+nums[i] == targetTmp) {  // ����Խ������,����int��ӻ��������ʱ��Ҫ���� �Ƿ��Խ�硣
                    list.add(nums[i]+"_"+nums[start]+"_"+nums[end]);
                }
                start++;
            }
        }

        return list;
    }


    // ������ O(n2)
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }

        Arrays.sort(nums);

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length-2; j++) {
                for(int p = j+1; p < nums.length-1; p++) {
                    for(int q = p+1; q < nums.length; q++) {
                        if (nums[i]+nums[j]+nums[p]+nums[q] == target) {
                            String tmp = nums[i]+"_"+nums[j]+"_"+nums[p]+"_"+nums[q];
                            set.add(tmp);
                        }
                    }
                }
            }
        }

        for (String tmp : set) {
            String[] s = tmp.split("_");
            ArrayList<Integer> listTmp = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                listTmp.add(Integer.parseInt(s[i]));
            }
            list.add(listTmp);
        }

        return list;
    }

}