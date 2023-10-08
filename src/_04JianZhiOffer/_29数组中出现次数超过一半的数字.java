package _04JianZhiOffer;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	  ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
	  ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬
	  ������2����������������0��
	
	˼·:ͨ��HashMap�����д�Ƶͳ��,Ȼ���ҵ����������Ǹ�Ԫ��(ֻ����һ��),�ж����Ĵ����ǲ��Ǵ������鳤�ȵ�һ��.
		(ʱ�临�Ӷ�=O(N)+O(n),N��������,n�����ظ���Ԫ�صĸ���)
 */
public class _29�����г��ִ�������һ������� {
	
	@Test
	public void main() {
		
		int[] arr = {1,2,3,2,2,2,5,4,2};
		int num = MoreThanHalfNum_Solution(arr);
		System.out.println(num);
	}
	
	public int MoreThanHalfNum_Solution(int [] arr) {
		//basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//����һ��hashmap��������Ƶͳ��,����keyΪ��ֵ,valueΪ��ֵ���ֵĴ���
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) { //���֮ǰͳ�ƹ�,�򽫴˴���һ
				int tem = map.get(arr[i]);
				map.put(arr[i], tem+1);
			} else{
				map.put(arr[i], 1);
			}
		}
		//��hashmap�еļ�ֵ�԰���value������(�õ�����value.�����Ƿ�������鳤�ȵ�һ��)
		Set<Integer> keySet = map.keySet();
		int retMaxVal = arr[0]; //ת���һ��Ԫ��
		for (Integer temKey : keySet) {
			retMaxVal = map.get(retMaxVal) > map.get(temKey) ? retMaxVal : temKey;
		}
		return map.get(retMaxVal) > arr.length>>1 ? retMaxVal : 0;
    }
}
