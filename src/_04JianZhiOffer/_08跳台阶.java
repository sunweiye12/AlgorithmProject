package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * 
 * ˼·:�ݹ����,����������n��̨�׵ĸ���Ϊ,������n-1̨��ʱ�ĸ���  + ������n-2̨��ʱ�ĸ���
 * 		
 */
public class _08��̨�� {

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
