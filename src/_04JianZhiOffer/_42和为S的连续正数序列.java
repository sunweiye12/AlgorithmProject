package _04JianZhiOffer;
import java.util.ArrayList;
import org.junit.Test;

/*
 * ��Ŀ:С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * 	���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,
 * 	���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * 	���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * (������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��)
 * 
 * ˼·:(ֱ�۱�����)���������ĺ�Ϊsum������,��������������.
 * 		����Դ�1��ʼ�ж�,���α鿴���ܲ������sum,����ɾ���ӵ�����list��
 * 			  2��ͷ���������ܲ������sum,����ɾ���ӵ�����list��
 * 			 ֱ��sum/2+1ʱ
 */
public class _42��ΪS�������������� {

	@Test
	public void main() {
	}
	
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum <= 1) {
			return list;
		}
		for (int i = 1; i <= sum/2; i++) { //�ж���i��ͷ�����������ܷ���ں�Ϊsum
			int j = i;
			int temSum = 0;
			while(temSum <= sum){
				temSum += j;
				j++;
				if (temSum == sum) {
					partionAdd(list,i,j-1); //��i��j��Ϊ������ӵ�list��
				} 
			}
		}
		return list;
    }

	private void partionAdd(ArrayList<ArrayList<Integer>> list, int i, int j) {
		ArrayList<Integer> temList = new ArrayList<Integer>();
		for(int p = i;p <= j;p++){
			temList.add(p);
		}
		list.add(temList);
	}
}
