package _04JianZhiOffer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 * 
 * ˼·:������hashmap��ʵ��,����keyΪ�ַ�,valueΪ���ַ����ֵ��±�
 * 		����set�ṹ�������Щ�Ѿ��ظ���Ԫ��
 * 		1.ÿ�η�Ԫ�ص�ʱ���ж�ʱ����ڴ�set���Ƿ����,�������ֱ������,����������ж�hashmap���Ƿ����,
 * 			���hashmap�в�����,��Ԫ����ӵ�map��,
 * 			������ھʹ�key�ظ���,������HahsMap��ɾ��,������Ԫ�ط��뵽set������
 * 		2.Ȼ��ͨ������һ���ҵ��±���С�Ǹ�key��λ����
 * 	ʱ��O(n) �ռ�:����һ������256���ַ�,�������࿪�ŵĿռ䶼Ϊ256,���ΪO(1)
 */
public class _35��һ��ֻ����һ�ε��ַ� {

	@Test
	public void main() {
		
		String str = "googgle";
		int i = FirstNotRepeatingChar(str);
		System.out.println(i);
	}
	
	public int FirstNotRepeatingChar(String str) {
		//basecase
		if (str == null || "".equals(str)) {
			return -1;
		}
		char[] arr = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.contains(arr[i])) { //���set�а�����Ԫ��,ֱ������������
				if (!map.containsKey(arr[i])) { //���map�в���������ӵ�map��,������map��ɾ������ӵ�set��
					map.put(arr[i], i);
				} else{
					map.remove(arr[i]);
					set.add(arr[i]);
				}
			} 
		}
		if (map.isEmpty()) {
			return -1;
		}
		Collection<Integer> values = map.values();
		int ret = Integer.MAX_VALUE;
		for (Integer integer : values) {
			ret = Math.min(ret, integer);
		}
        return ret;
    }
}
