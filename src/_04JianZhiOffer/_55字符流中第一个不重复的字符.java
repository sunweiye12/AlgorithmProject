package _04JianZhiOffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
 * 	���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
 * 	���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"
 * 
 * ˼·:��������hashmap��ʵ��,����keyΪ��Ԫ��,��valueΪ�����ڵ��±�
 * 		ÿ�ν�putԪ��ʱ,�����㵫�Ƿ����,����������ɾ��,�������������ֵ�Ͷ�Ӧ���±� �ŵ�map��
 * 		���õ�����map�е�value,ѡ����С��,����ֵ����
 */
public class _55�ַ����е�һ�����ظ����ַ� {

	@Test
	public void main() {
		
	}
	
	public String str = "";
	
    public void Insert(char ch){
        str += ch;
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(map.containsKey(arr[i])){
                map.remove(arr[i]);
            } else{
                map.put(arr[i],i);
            }
        }
        if(map.size()==0){
            return '#';
        }
        //���ڷ��ص�Ԫ��
        boolean flag = false;
        char ret = '#';
        Set<Character> keySet = map.keySet();
        for (Character keys : keySet) {
        	if(!flag){
        		ret = keys;
        		flag = true;
        	} else{
        		ret = map.get(ret) < map.get(keys)? ret: keys;
        	}
		}
        return ret;
    }
}
