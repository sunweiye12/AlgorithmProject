package _04JianZhiOffer;
import org.junit.Test;
/*
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�����
 * ˼·:�Ӷ�ά��������Ͻǿ�ʼ,ֻ������ѡ��,����ı��Լ�С,����ı��Լ���
 */
public class _01��ά�����еĲ��� {

	@Test
	public void main() {
		int[][] matr = getMatr();
		myPrint(matr);
		System.out.println(Find(4, matr));
	}
	
	
    public boolean Find(int target, int [][] array) {
    	if (array==null) {
    		return false;
		}
    	int line = array.length; //����
    	int column = array[0].length; //����
    	//��ʼ����±�(��һ�����һ��)
    	int p1 = 0;
    	int p2 = column-1;
    	while(p1<line && p2 >= 0){
    		if (array[p1][p2] < target) {
    			p1++;
			} else if(array[p1][p2] > target){
				p2--;
			} else {
				return true;
			}
    	}
    	
    	return false;
    }
    
    
	
	//��ȡһ��m��n�еľ������-----------------------------------------
	private int[][] getMatr() {
		int[][] matr = {{1,2,3,5},
				{3,5,9,10},
				{7,8,13,14}};
		return matr;
	}
		
	//��ӡ��ά����
	public void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
