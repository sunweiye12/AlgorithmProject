package _07LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * 链接: https://leetcode.cn/problems/4sum/description/
 *  
 *  疑问：至少要有4个及以上的元素，要不然返回一个空数组？
 *       存在越界问题,两个int相加或者相减的时候都要考虑 是否会越界
 *  1. 要所有可能的解
 *  2. 求解中不能有重复的四元组
 *
 *  思路：因为不能有重复的元素，所以第一步我们是对数组进行排序 O(nlogn)
 *  然后依次遍历每一个元素，遍历完之后剩下的问题就是三个数相加的问题o(n2)，因此这个题整体的时间复杂度是n(n3)
 */

public class _404哈希表_四数之和18 {

    @Test
    public void main() {
        System.out.println("开始");
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
            // 转换成三数相加的问题
            // 在下标为i+1到尾部的位置中，找到相加为target-num[i]的所有数据 --（此处不需要去重，区中后续统一考虑）
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
                if ((long)nums[start]+nums[end]+nums[i] == targetTmp) {  // 存在越界问题,两个int相加或者相减的时候都要考虑 是否会越界。
                    list.add(nums[i]+"_"+nums[start]+"_"+nums[end]);
                }
                start++;
            }
        }

        return list;
    }


    // 暴力法 O(n2)
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