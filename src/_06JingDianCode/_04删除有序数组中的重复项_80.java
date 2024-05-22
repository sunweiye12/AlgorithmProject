package _06JingDianCode;

import org.junit.Test;

import java.util.Arrays;

/*

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1：
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
示例 2：
输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
*/
public class _04删除有序数组中的重复项_80 {


    @Test
    public void main() {
        System.out.println("开始");

        int[] nums = {0,0,1,1,1,1,2,3,3};

        System.out.println(removeDuplicates(nums));

        System.out.println(Arrays.toString(nums));

        System.out.println("结束");

    }

    // {0,0,1,1,1,1,2,3,3};
    // {0,0,1,1,2,3,3   ,3,3};
    public int removeDuplicates(int[] nums) {
        int index = 0; //当前指针遍历的位置
        int cur = 0; //当前要填充字段的位置
        int n = 0; //移除掉的重复数字的个数
        int flag = 1; //每组重复数字的个数,判断这组是不是包含2个或以上元素

        // 考虑极端情况
        if (nums.length <= 0) return nums.length;

        // 遍历数据(三个和以上元素)
        while (index <= nums.length - 2) { // 遍历到倒数第二的位置就可以

            while ((index <= nums.length - 2) && (nums[index] == nums[index+1])) {
                index ++;
                flag ++; // 说明有多个元素
                if (flag > 2) {
                    n ++;
                }
            }


            // 如果没有到头
            if (flag > 1) {
                nums[cur] = nums[index];
                nums[cur+1] = nums[index];
                cur = cur + 2;
            } else {
                nums[cur] = nums[index];
                cur ++;
            }
            index ++;
            flag = 1;

            // 先判断是不是到头了
            if (index == nums.length-1) {
                nums[cur] = nums[index];
            }

        }
        return nums.length - n;
    }

}