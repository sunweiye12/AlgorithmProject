package _04JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/*
 *�ֵ���:
 * һ��ȫ���пɿ���һ���ַ�����ջ�ҵ�����ȫ��������С��ȫ����,Ȼ�������ҵ�����һ��,ֱ������ȫ���С�
 * ������Ѱ����һ��ȫ����ʱ,Ҫ����һ����ǰһ���о����ܳ��Ĺ�ͬǰ׺��Ҳ���仯�����ھ����̵ܶĺ�׺�ϡ�
 * [��]839647521��1--9�����С�1��9��������ǰ�����123456789��������987654321��
 * ��������ɨ�����������ģ��͵���987654321��Ҳ��û����һ���ˡ������ҳ���һ�γ����½���λ�á�
 * ������ ��εõ�346987521����һ��
 * 1����β����ǰ�ҵ�һ��P(i-1) < P(i)��λ��(�ҵ���һ�������½���λ��)
 * 		3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
 * 		�����ҵ�6�ǵ�һ����С�����֣���¼��6��λ��i-1
 * 2����iλ�������ҵ����һ������6����(�ҵ����һ�����½�λ�ô��Ԫ��)
 * 		3 4 6 -> 9 -> 8 -> 7 5 2 1
 * 		�����ҵ�7��λ�ã���¼λ��Ϊm
 * 3������λ��i-1��m��ֵ(����)
 * 		3 4 7 9 8 6 5 2 1
 * 4������iλ�ú����������(���½�λ�õĺ�׺,����)
 * 		3 4 7 1 2 5 6 8 9
 * 		��347125689Ϊ346987521����һ������
 */
public class _28ȫ����_�ַ���_�ֵ��� {

	@Test
	public void main() {
		String str = "123";
		ArrayList<String> list = Permutation2(str);
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	//�ֵ���������
	public ArrayList<String> Permutation2(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars); //����õ���С��ȫ����
        list.add(String.valueOf(chars)); //����ȫ�������
        
        int len = chars.length;
        while(true){
            int lIndex = len-1; //������
            int rIndex;			//������
            //�Ӻ���ǰ��ѯ,�ҵ���һ���½����ַ�(ΪlIndex-1��λ��)
            while(lIndex > 0 && chars[lIndex-1] >= chars[lIndex]){
                lIndex--;
            }
            //�����һ���½���λ����0��ǰ,��˵���Ѿ��鵽�����ȫ����,û�б��������ȫ����(ֱ���˳�)
            //Ŀ�����ҳ��ȵ�ǰ��һ��ȫ����,������,����������Ӧ����ǰ���Ѿ�������
            if(lIndex == 0)
                break;
            //�ҵ����������һ���������Ԫ��(��������ΪrIndex-1)
            rIndex = lIndex;
            while(rIndex < len && chars[lIndex - 1] < chars[rIndex]){
                rIndex++;
            }
            //������Ԫ�ؽ���
            swap(chars,lIndex-1,rIndex-1);
            //��lIndex��ĺ�׺��ת(����lIndex)-->��ȡ������һ��Ԫ��
            reverse(chars,lIndex);
            list.add(String.valueOf(chars));
        }
        return list;
    }
 
	//������k�±��Ԫ�ط�ת
    private void reverse(char[] chars,int k){
        if(chars==null || chars.length<=k)
            return;
        int len = chars.length;
        //�൱���ҵ��Գ�����Ȼ��ת
        for(int i=0;i<((len-k)/2);i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
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
