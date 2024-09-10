package _07LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 链接: https://leetcode.cn/problems/3sum/description/
 *  
 *  疑问：如果没有符合的结果直接返回一个空数组？
 *  数组的长度至少 >= 3
 *  需要所有组合，且不考虑顺序，不重复。
 *  不包含重复解
 *
 *
 * 思路1：暴力解法
 *  三个下标，i，j，p，依次遍历
 *  i = 0，length
 *  j = i+1,length
 *  p = j+1,length
 *  将符合结果的数组排序，然后用‘—’拼接起来，放到set中，最后将set中的元素分别拿出来用 ‘-’ 切割开，返回到结果中。
 *
 *  时间负责度 O(n3)  空间O(n)
 **
 *  思路2：借助‘两数之和’的经验，这个问题的难点是要找所有且不重复的解。
 *  因此第一步现将数组排序，然后从左到右遍历，
 *  每次遍历到一个数之后 找另外两个数据就就是 两数之和的问题，但是由于这个数组是排序之后的，且需要所有解。
 *  也因此可以通过双指针来解：
 *  start初始在头
 *  end初始化在尾部
 *  如果两数之和小于目标值，start右移动，
 *  大于目标值，end左移动，否则输出结果。直到start和end相遇。
 *
 *  O(n2)
 *
 *
 */

public class _403哈希表_三数之和15 {

    @Test
    public void main() {
        System.out.println("开始");
        int[] arr = new int[]{-1,0,1,2,-1,-4};

        List<List<Integer>> res = threeSum(arr);
        System.out.println(res);
    }


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];

            // 双指针问题解决两数之和的所有答案
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
                    //跳到相同的元素的最后一个
                    while (start+1 < nums.length && nums[start] == nums[start+1]) {
                        start++;
                    }
                    start++;
                }
            }
            //跳到相同的元素的最后一个
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return list;
    }


}