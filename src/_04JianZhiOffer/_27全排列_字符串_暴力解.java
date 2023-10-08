package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * 		���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 		����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
* 1���ݹ��㷨
 * �̶���һ���ַ����ݹ�ȡ����λ����ĸ����ַ�����ϣ�
 * ��һ���ַ������ÿһ���ַ�����,�õ�һ�齻������ַ�����
 * Ȼ���õõ����ַ����ӵڶ�λ��ʼ,�����ÿһλ������ڶ�λ����,�õ��µ��ַ���....���ν���
 * ֱ���ߵ����һλʱ����,�����ɵ��ַ����ŵ�list�������档
 * �������ظ�ֵ�أ�
 * ��ÿһ�ֽ�����ʼʱ����һ��set����,Ȼ��Ȼ�󽻻�ǰ�ж�һ��ǰ���Ƿ���ͬ��Ԫ�����ͷ�Ľ�������,����еĻ�˵��û�б�Ҫ�ڽ�����
 */
public class _27ȫ����_�ַ���_������ {

	@Test
	public void main() {
		String str = "123";
		ArrayList<String> list = Permutation(str);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	
	public ArrayList<String> Permutation(String str){
		//����һ�����ڷ��ص�list����
		ArrayList<String> list = new ArrayList<String>();
        //basecase
        if(str == null || str.length() == 0){
             return list;
        }
        //���÷���,������ȫ���з���list������
        partion(str.toCharArray(),0,list);
        //Ĭ�ϸ����ֵ������,�Լ��Ͻ�������
        Collections.sort(list);
        return list;
    }
	    
	//��ȫ���з��뼯����(�ݹ�)
	private void partion(char[] chars,int i,ArrayList<String> list){
	    //����������һ��Ԫ��ʱ,���ַ�����ת�����ַ���,װ��list��
	    if(i == chars.length-1){
	        list.add(String.valueOf(chars));
	    }
	    //�ӵ�һ��Ԫ�ؿ�ʼ,�����Ԫ���������һ�����н���(��������ظ�Ԫ���򲻽���)
	    Set<Character> charSet = new HashSet<Character>(); //Ϊ�˱�����ͬԪ��-->��ͬԪ��ʱֻ�е�һ�����н���
	    for(int j=i;j<chars.length;j++){
	        if(!charSet.contains(chars[j])){ //��һ�»���������û��,û��ʱ�ڽ�����һ��
	            charSet.add(chars[j]);//��Ԫ�طŵ�������
	            swap(chars,i,j);      //��ʼ����Ԫ��
	            partion(chars,i+1,list); //����һλ��ʼ�ж�
	            swap(chars,i,j);      //�ٻ����� ,�Ա㲻Ӱ������˳��
	        }
	    }
	}
	    
    //��������Ԫ��
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
