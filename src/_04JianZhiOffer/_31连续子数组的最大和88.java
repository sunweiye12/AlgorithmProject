package _04JianZhiOffer;

import org.junit.Test;

/*
 * ��Ŀ:HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * 	��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
 * 	������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,
 * 	�������Աߵ��������ֲ����أ�
 * 	����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * 	��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 *
 *˼·:˫ָ��������1.��������ָ��left��right��ʼλ��ʼλ��[0],�����sumΪleft��rightԪ�صĺ�(֪ͨ����һ��ȫ�ֵ�Msum��¼����sum)
 *		2.ÿ��rigth�����ƶ�һ���õ�һ����sum,�ж�sum�Ƿ������,�������0���������ƶ�
 *		3.���sumС�ڵ���0,�Ǿͽ�left��rightͬʱָ��right����һλ
 *		4.ֱ��right�������Ҷ��Ժ�,left�����������ƶ�,ֱ�����Ҷ˽���
 */
public class _31���������������88 {

    @Test
    public void main() {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        int num = FindGreatestSumOfSubArray(arr);
        System.out.println(num);
    }

    public int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;    //˫ָ��
        int right = 0;
        int sum = arr[0];        //˫ָ��֮��ĺ�
        int Msun = arr[0];    //ȫ������
        while (right < arr.length - 1) {
            sum += arr[++right];
            Msun = Math.max(sum, Msun);
            if (sum <= 0 && right < arr.length - 1) { //�жϲ���Խ��
                sum = arr[++right];
                Msun = Math.max(sum, Msun);
                left = right;
            }
        }
        //��right�������ұ�ʱ
        while (left < arr.length - 1) {
            sum -= arr[++left];
            Msun = Math.max(sum, Msun);
        }
        return Msun;
    }
}
