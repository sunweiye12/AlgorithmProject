package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ? n/2 ? 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：
输入：nums = [3,2,3]
输出：3

示例 2：
输入：nums = [2,2,1,1,1,2,2]
输出：2
*/
public class _05多元素数组_169 {


    @Test
    public void main() {
        System.out.println("开始");

        int[] nums = {2,2,1,1,1,2,2};

        System.out.println(majorityElement(nums));

        System.out.println(Arrays.toString(nums));

        System.out.println("结束");

    }


    public int majorityElement(int[] nums) {

        int t = nums[0]; // 候选元素
        int c = 1; // 获取票数

        for (int i = 1; i < nums.length; i++) {
            if (t == nums[i]) {
                c++;
            } else {
                c--;
                if(c == 0) {
                    t = nums[i+1];
                }
            }
        }
        return t;

    }


}