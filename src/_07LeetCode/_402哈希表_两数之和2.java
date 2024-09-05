package _07LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


/**
 * 链接:https://leetcode.cn/problems/two-sum/description/
 *  
 *  疑问：数组至少有两个以上的元素？
 *       是否一定有两个元素可以凑出整数 num，如果凑不出来的话，结果怎么返回？
 *       给定的数据中是否会存在两个相同的元素--不能使用两次相同的元素，但是数组中可能会存在相同值的元素。
 *
 *  思路1：暴力法：进行两层遍历，查看最终将符合要求的两个元素下标返回。
 *         时间 O(n2) 空间 O(n)
 *
 *  思路2：通过一个hashMap结构来优化其时间复杂度，将数据中的元素都放到一个hashMap中，kay为只，value为其下标。然后依次遍历
 *        sum[i]从hashMap中移除，病判断 num - sum「i】 是否在map中存在，如果存在就返回两个元素的 index
 *
 */

public class _402哈希表_两数之和2 {

    @Test
    public void main() {
        System.out.println("开始");

        int[] arr = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum2(arr,9))); // 返回 4
    }

    // 思路1
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


    // 思路2 简洁的写法
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