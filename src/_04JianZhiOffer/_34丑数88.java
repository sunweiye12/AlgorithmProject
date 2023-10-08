package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:��ֻ����������2��3��5��������������Ugly Number����
 * 		����6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * 		ϰ�������ǰ�1�����ǵ�һ��������
 * 		�󰴴�С�����˳��ĵ�N��������
 * 
 * ˼·1(������):��ν�ĳ�����ֻ�ܹ���2 3 5��Ϊ���ӵ���,���Զ���һ���������ϳ���2,���ϳ���3,���ϳ���5�Ժ�һ��Ϊ1,
 * 		����ͨ����һ�����жϴ����ǲ��ǳ���,���������ж�ĳһ�����ǲ��ǳ���.
 * ˼·2(dp��):��������Ľⷨ��Ҫ�����������ǲ��ǳ���,���ʱ�为����ر��,
 * 		���ڳ�����ֻ����2,3,5������,�������еĳ���������ǰ��ĳ�������2,3��5������
 * 		������n������,���ǿ��Դ���һ������Ϊn������,�ֱ������1��n������
 * 		��ô��δӺε�i�����������i+1��������?
 * 		iΪ֮ǰ�����г�������2�õ��պô���iλ���Ǹ���min1,
 * 		ͬ��,iΪ֮ǰ�����г�������3�õ��պô���iλ���Ǹ���min2,
 * 		ͬ��,iΪ֮ǰ�����г�������5�õ��պô���iλ���Ǹ���min3,��iΪ����һ������һ��Ϊmin1,min2,min3����С���Ǹ�
 * 		ʵ���������ʱ��û�б�Ҫ��i֮ǰ�����г�������2���,��Ϊ֮ǰ�ĳ����������,������ǿ���һֱ�ҵ�����ٽ�λ
 */
public class _34����88 {
	
	@Test
	public void main() {
		int num = GetUglyNumber_Solution_baoli(9); //�����ⷨ
		int num1 = GetUglyNumber_Solution(9); //DP�ⷨ
		System.out.println(num);
	}
	
	//��̬�滮�ⷨ
	public int GetUglyNumber_Solution(int size) {
		//basecase  �����쳣����
		if (size <= 0) {
			return 0;
		}
		int[] dp = new int[size]; //��������
		dp[0] = 1; //��һ������λ1
		int nextIndex = 1; //ָ����һ��������ָ��
		//���������ٽ�ֵ(ָ��dp�������±�)
		int intMut2 = 0; //��2����intMut2ָ��ĳ����պô���Ŀǰ����ǳ���
		int intMut3 = 0;
		int intMut5 = 0;
		while(nextIndex < size){
			int minChou = Math.min(Math.min(dp[intMut2]*2, dp[intMut3]*3),dp[intMut5]*5); //��ȡ��Сֵ
			dp[nextIndex] = minChou;
			nextIndex++;
			while(dp[intMut2]*2 <= minChou) intMut2++;
			while(dp[intMut3]*3 <= minChou) intMut3++;
			while(dp[intMut5]*5 <= minChou) intMut5++;
		}
		return dp[size-1];
	}

	//������
	public int GetUglyNumber_Solution_baoli(int size) {
		//basecase  �����쳣����
		if (size <= 0) {
			return 0;
		}
		int num = 0;		//���ڷ��صĳ���
		int uglyFound= 0; 	//����������
		while (uglyFound < size) {
			num++;
			if (isChoushu(num)) {//������һ�������������ͼ�1
				uglyFound++;
			}
		}
        return num;
    }
	
	public boolean isChoushu(int num){
		//ֻҪ�������ͽ��г�������
		while(num % 2 == 0) num = num/2;
		while(num % 3 == 0) num = num/3;
		while(num % 5 == 0) num = num/5;
		//������Ϊ1,˵���ǳ���
		return num == 1;
	}
}
