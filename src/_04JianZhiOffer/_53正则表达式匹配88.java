package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:
 *  ����һ���ַ��� (s) ��һ���ַ�ģʽ (p)��ʵ��֧�� '.' �� '*' ��������ʽƥ�䡣
	'.' ƥ�����ⵥ���ַ���
 	'*' ƥ���������ǰ���Ԫ�ء�(���ܷŵ���λ)
	ƥ��Ӧ�ø��������ַ��� (s) �������ǲ����ַ�����
	˵��:
	s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
	p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
 * ����˼·:
//��Ϊ*����ַ��Ƚ�����,����ж�i~ ��j~ ʱ Ҫ���� j+1λ���Ƿ�Ϊ * (����j+1��Խ��)
	//	1.���j+1λ���ϲ���*,�����ƥ��ɹ�������i��j��λ����ƥ���ϼ�:exp[j] == str[i] || exp[j] == '.'  ,����һ��false
	//		��������������ʱ(i��j��λ����ƥ����),i~ ��j~ ����ƥ����,���뻹��isMatch(str,exp,i+1,j+1)Ϊtrue
	//	2.���j+1λ����ʽ*,���j+1λ��Ϊ*,��j��*��������
	//		1.���iλ�ú�jλ��ƥ�䲻�ɹ�,��ֻ����jλ�õ���Ϊ0��,����ת��ΪisMatch(str,exp,i,j+2)
	//		2.���iλ�ú�jλ��ƥ��ɹ�,��j*,Ϊ0��jʱ,���isMatch(str,exp,i,j+2)�ܳɹ��ͷ���true,����
	//							��j*,Ϊ1��jʱ,���isMatch(str,exp,i+1,j+2)�ܳɹ��ͷ���true,����
	//							��j*,Ϊ2��jʱ,���isMatch(str,exp,i+2,j+2)�ܳɹ��ͷ���true,����,ֱ��iԽ��
 */
public class _53������ʽƥ��88 {

	@Test
	public void main() {
		String str = "aab";
		String exp = "c*a*b";
		//���õݹ麯�������Ƿ���ƥ��(str��0��ʼ,exp��0��ʼ�Ƿ���ƥ����)
		boolean h = isMatch(str.toCharArray(),exp.toCharArray(),0,0);
		System.out.println(h);
	}
	
	//�ݹ�ⷨ:��ʾstr[i...�����]�ܷ�exp[j...�����]���ַ���ƥ��ɹ� || (ǰ��Ĳ��ÿ���)
	private boolean isMatch(char[] str, char[] exp ,int i, int j) {
		//basecase��exp��βû��Ԫ���ˣ�ֻ��strҲ��βû��Ԫ���ˣ���ƥ��ɹ�
		if (i == str.length && j == exp.length) { 
			return true;
		}
		//exp�ȵ�βû��Ԫ���ˣ���strû�е���β��,��ƥ��ʧ��
		if (i != str.length && j == exp.length) {
		    return false;
		}

		//��j������ֹλ�õ�ʱ��,Ҳ�������һ���ַ�ʱ,������� 
		if (j == exp.length - 1 ) {
			if (i >= str.length) { //���j����һ���ַ�,��iû����,�򷵻�false
				return false;
			}
			//�����ж�
			return (exp[j] == str[i] || exp[j] == '.') && isMatch(str, exp, i + 1, j + 1);
		}
		
		//exp��j���滹���ַ�,����j+1�����,��j+1��Ӧ�ַ���Ϊ*ʱ
		if (exp[j+1] != '*') { 
			if (i >= str.length) { //���j����һ���ַ�,��iû����,�򷵻�false
				return false;
			}
			return (exp[j] == str[i] || exp[j] == '.') && isMatch(str, exp, i + 1, j + 1);
		}
		
		//exp��j+1���ַ�Ϊ * ,����i��jλ�õ��ַ�����ƥ���� 
		while(i < str.length && (exp[j] == str[i] || exp[j] == '.')){
			if (isMatch(str, exp, i, j+2)) {
				return true;
			}
			i++;
		}
		//exp��j+1���ַ�Ϊ * ,����i��jλ�õ��ַ�������ƥ�� 
		return isMatch(str, exp, i, j+2);
	}
}
