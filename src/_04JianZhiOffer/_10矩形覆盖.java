package _04JianZhiOffer;
/*
 * ��Ŀ:���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * 	        ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * ˼·:�������֪ n=0 0��
 * 			   n=1 1��
 * 			   n=2 2��
 * 			   n=3 3��
 *             n=4 5��	
 *  �ӵ�������ʼ��ǰֵΪǰ����ֵ�ĺ�
 */
public class _10���θ��� {

	 public int RectCover(int target) {
		 //basecase
		 if (target == 0) return 0;
		 if (target == 1) return 1;
		 if (target == 2) return 2;
		 return RectCover(target-1) + RectCover(target-2);
	 }
}
