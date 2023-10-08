package _04JianZhiOffer;

import java.util.LinkedList;

import org.junit.Test;

/*
 * ��Ŀ:����Լɪ������,һ����n����,�˵ı��Ϊ0~n-1,�����ļ��Ϊm
 * 		�������һ���˵�ʱ��,���ı��
 * 
 * ˼·:˳��,��ÿ������װ��������,Ȼ����������m����ȥ��,Ȼ���ڴ�m+1��ʼ����m��ɾ��,ֱ�����ʣ��1��Ԫ��ʱ
 * ˼·:��ʽ��,�����ҵ�ɾ��һ�����û��ɾ��ǰÿһ��Ԫ��֮��������ϵ,
 * 		��֪���ֻʣһ��ʱ,��Ԫ�ص��±�һ��Ϊ0,��ͨ�����Ƴ�������Ԫ��ʱ���±�,Ȼ���Ƴ�������Ԫ��ʱ���±�,
 * 		ֱ���Ƴ�����n��Ԫ��ʱ���±꼴Ϊ����
 */
public class _47�����ǵ���Ϸ_ԲȦ�����ʣ�µ���88 {

	@Test
	public void main() {
		int  res = LastRemaining_Solution(41, 3); //һ����5����,����3
		int  res1 = LastRemaining_jinjie1(41, 3); //һ����5����,����3
		System.out.println(res);
		System.out.println(res1);
	}
	
	//���׽������(����n������,��m,���ʣ���˵�����)
	private int LastRemaining_jinjie(int n, int m) {
		if(n <= 0 || m <= 0)
			return -1;
		if(n == 1){
			return 0; //���ֻ��һ���˵�haul�ͷ����±�0
	   	}
	 	return (LastRemaining_Solution(n-1, m)+m)%n;
	}
	
	//�ǵݹ��
	private int LastRemaining_jinjie1(int n, int m) {
		if(n <= 0 || m <= 0)
			return -1;
		if(n == 1){
			return 0; //���ֻ��һ���˵�haul�ͷ����±�0
		}
		int ret = 0; //����ʣ��һ��Ԫ��ʱ�±�Ϊ0-->Ȼ���Ƴ�n��Ԫ��ʱ���Ӧ������
		for(int i = 1;i < n; i++){	//�Ƶ�n-1��
			int tem = (ret+m)%(i+1); //i+1��Ԫ��ʱ����Ӧ���±�Ϊ   --->  ����ͨ��iԪ������Ӧ���±��Ƴ�����i+1��Ԫ��ʱ��Ӧ���±�
			ret = tem;
		}
		return ret;
	}

	//ͨ��������ģ����Ϸ����
	public int LastRemaining_Solution(int n, int m) {
		//basecase
		if (n<=0 || m<=0) {
			return -1;
		}
		//����Ч�ʸ�
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i ++) { //�±�Ϊ0~n-1
		    list.add(i); 	//��Ԫ�ض���Ӵ�������
		}
		int bt = 0; 		//�ӵ�0��λ�ÿ�ʼ��ʱ
		while (list.size() > 1) {
		    bt = (bt + m - 1) % list.size(); //ÿ��Ҫɱ�������±�
		    list.remove(bt); 	//ɾ���±�
		}
		return list.get(0);		//�������ʣ���Ԫ��
    }
}
