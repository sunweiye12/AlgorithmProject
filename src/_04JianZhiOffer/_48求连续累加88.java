package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 * ˼·:	1.�������߼���Ķ�·����ʵ�ֵݹ���ֹ�� 
 * 		2.��n==0ʱ��(n>0)&&((sum+=Sum_Solution(n-1))>0)ִֻ��ǰ����жϣ�Ϊfalse��Ȼ��ֱ�ӷ���0��
 * 		3.��n>0ʱ��ִ��sum+=Sum_Solution(n-1)��ʵ�ֵݹ����Sum_Solution(n)��
 */
public class _48�������ۼ�88 {

	@Test
	public void main() {
		int sum = Sum_Solution(5);
		System.out.println(sum);
	}
	public int Sum_Solution(int n) {
		int sum = n;
		//�߼���Ķ�·����,Ҳ����˵ֻ�е�n>0ʱ���жϺ����(��ִ�еݹ�),��n=09ʱֱ�ӷ���0
        boolean flag = (n>0) && ((sum+=Sum_Solution(n-1))>0); 
        return sum;
    }
}
