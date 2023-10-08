package _04JianZhiOffer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:һ����һ��54��,����һ��56�ŵ��˿���(����һ�Դ�С��),����������������,�ж��ǲ���˳�� (��С����Ϊ��0)--���д�С�����Դ���������
 * 		�൱��0-13ÿ����������4��
 * 
 * ˼·:�����5����.���������ж����Ƿ�Ϊ˳��
 * 		1.����������е������,�򷵻�false
 *		2.����������,���ҵ�5����������������С����,�����ֵΪ5�򷵻�true.���򷵻�false
 */		
public class _46�˿���˳�� {

	@Test
	public void main() {
		int[] num = {0,3,2,6,4};
		boolean b = isContinuous(num);
		System.out.println(b);
	}
	
	public boolean isContinuous(int [] num) {
		//basecase
		if (num==null||num.length < 5) {
			return false;
		}
		//��������ȥ�ص�set����
		Set<Integer> set = new HashSet<Integer>();
		int max = Integer.MIN_VALUE;//ȫ�����ֵ
		int min = Integer.MAX_VALUE;//ȫ�����ֵ
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) { //�����0�Ļ�������,������set�еĸ��������ж�0�ĸ���
				continue;
			}
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
			if (!set.contains(num[i])) { //����������ͷŽ���
				set.add(num[i]); 
			} else{						//���������˵���ظ�,�򷵻�false
				return false;
			}
		}
		int lingSize = 5 - set.size(); //����0�ĸ���
		if (lingSize == 0) {
			return max-min==4;
		} else if(lingSize == 1){
			return max-min==4 || max-min==3;
		} else if (lingSize == 2){
			return max-min==4 || max-min==3|| max-min==2;
		} else if (lingSize == 3){
			return max-min==4 || max-min==3|| max-min==2 || max-min==2;
		} else if (lingSize == 4){
			return true;
		}
		return true;
    }
}
