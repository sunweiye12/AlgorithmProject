package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右轮转 1 步: [7,1,2,3,4,5,6]
向右轮转 2 步: [6,7,1,2,3,4,5]
向右轮转 3 步: [5,6,7,1,2,3,4]

示例 2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
*/
public class _06轮转数组_189 {


    @Test
    public void main() {
        System.out.println("开始");

        int[] nums = {2,2,1,1,1,2,2};


        System.out.println(Arrays.toString(nums));

        System.out.println("结束");

    }


    public void rotate(int[] nums, int k) {

    }


}