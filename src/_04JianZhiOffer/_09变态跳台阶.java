package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * 
 * ˼·:��������Եõ� 1 1 2 4 8 16 ... (��һ��Ϊn==0ʱ)
 * 		������ǿ��Եó�,��n==2��ʼ ����Ķ���ǰ�������
 * dp��:����һ��һλ���鳤��Ϊn+1  dp[0]��dp[1]==1
 * 		�����Ϊǰ�����Ķ���   ��󷵻�dp[n]
 * 
 */
public class _09��̬��̨�� {
	@Test
	public void main() {
		System.out.println(JumpFloor(3));
	}
	
	public int JumpFloor(int target) {
		//basecase
		if (target == 0 || target == 1) {
			return 1;
		}
		return 2 * JumpFloor(target - 1);

    }
	
	public int JumpFloorDB(int n) {
		if (n<=1) {
			return 1;
		}
		//DB��
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = 2 * dp[i-1];
		}
		return dp[n];
    }

}
