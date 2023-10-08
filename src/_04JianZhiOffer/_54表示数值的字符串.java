package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * 	���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� 
 * 	����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 * 
 * ˼·:�������ж�
 */
public class _54��ʾ��ֵ���ַ��� {

	@Test
	public void main() {
		char[] str = "123.45e+6".toCharArray();
		boolean b = isNumeric(str);
		System.out.println(b);
	}
	public boolean isNumeric(char[] str) {
		//�������������������->���š�С���㡢e�Ƿ���ֹ�
		boolean sign = false;	//����
		boolean decimal = false;//С����
		boolean hasE = false;	//E
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length-1) return false; // ���e�����ڽ�β,��false,(e����һ��Ҫ������)
                if (hasE) return false;  // ����ͬʱ��������e
                hasE = true;
            }else if (str[i] == '+' || str[i] == '-') {
                // �ڶ��γ���+-���ţ�����������e֮��
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
                // ��һ�γ���+-���ţ��Ҳ������ַ�����ͷ����Ҳ���������e֮��
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
                //��һ�γ���
                sign = true;
            } else if (str[i] == '.') {
                // e���治�ܽ�С���㣬С���㲻�ܳ������� 
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // ���Ϸ��ַ�
                return false;
		}
		return true;
    }
}
