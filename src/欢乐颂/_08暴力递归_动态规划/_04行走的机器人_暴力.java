package 欢乐颂._08暴力递归_动态规划;

import org.junit.Test;

/*
 * 思路:一个长度为N的路,1~N,一个机器人在M位置，他可以走P步，如果在1位置只能走右，在N位置只能走左，请问机器人走P步后他停在K位置上的走法有多少种。
 * 例如n=4 m=2 p=2 k=2   1-2-3-4  就是它从2位置走两步来到2位置,一共有2中分别为 2->3->2  2->1->2
 * 思路1:暴力递归：定义一个函数f(N,M,P,K)
 * 		K和N是固定的，表示 K位置 和 N为路的长度，
 * 		P和M是可变的，P表示当前剩余多少步能走 M表示当前在路的什么位置*(如果p和m确定返回结果就确定了)
 * 		返回值为当前状态下 机器人最终停在K位置的走法
 */
public class _04行走的机器人_暴力 {

	@Test
	public void main() {
		int n = 4; // 路的长度
		int m = 2; // 当前位置
		int step = 2; // 可以走的步数
		int aim = 2; // 目标位置
		int num1 = baoli(n, m, step, aim);
		System.out.println(num1);
	}

	// 暴力递归法
	private int baoli(int n, int m, int step, int aim) {
		// basecase
		if (n < 1 || m < 1 || m > n || step < 0 || aim > n) {
			return 0;
		}
		//当剩余步数为0时判断,当前位置是否在目标位置上
		if (step == 0) {
			return m == aim ? 1 : 0;
		}
		// 声明返回结果
		int count = 0; 
		// 否则说明还可以走
		if (m == 1) { // 走到左边界
			count = baoli(n, m + 1, step - 1, aim);
		} else if (m == n) { // 走到右边界
			count = baoli(n, m - 1, step - 1, aim);
		} else { // 在中间的时候(可以向左也可以向右)
			count = baoli(n, m + 1, step - 1, aim) + baoli(n, m - 1, step - 1, aim);
		}
		return count;
	}
}
