package _04剑指offer;

import org.junit.Test;

/*
 * 题目:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 
 * 思路:递归完成,青蛙跳到第n节台阶的个数为,跳到第n-1台阶时的个数  + 跳到第n-2台阶时的个数
 * 		
 */
public class _08跳台阶 {

	@Test
	public void main() {
		System.out.println(JumpFloor(3));
	}
	public int JumpFloor(int target) {
		//basecase
		if (target == 0 || target == 1) {
			return 1;
		}
		return JumpFloor(target - 2) + JumpFloor(target - 1);

    }
}
