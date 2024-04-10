package _04JianZhiOffer;

import java.util.ArrayList;

import org.junit.Test;

/*
 * ��Ŀ:����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * 	���磬�����������4 X 4���� 
 * 			1  2  3  4 
 * 			5  6  7  8 
 * 			9  10 11 12 
 * 			13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 * ˼·:�����Ϻ����µ����궨λ��һ��Ҫ��ת��ӡ�����ݣ�һ����ת��ӡ���������ԽǷֱ�ǰ���ͺ���һ����λ��
    	�ύ����ʱ����Ҫ��������ڣ���Ҫ���������жϣ���ֹ���ֵ��л��ߵ��е������(Ҫ���������,���Ǳ߿�ʼ��ӡ)
 */

public class _19˳ʱ���ӡ����88 {
	
	@Test
	public void main() {
		int[][] arr = getMatr(3,4);
		myPrint(arr); //��ӡ��ά����
		//����ѭ����ӡ�ĺ���
		printMatrix(arr);
	}
	
	//����һ����ά����,����ת��ӡ����Ϣ����list������
	public ArrayList<Integer> printMatrix(int [][] arr) {
		if (arr == null || arr.length == 0 || arr[0].length == 0) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<Integer>(); //����һ�����ڷ��صļ���
		int p1 = 0;					//��ʼ��
		int p2 = 0;					//��ʼ��
		int p3 = arr.length - 1;	//��ֹ��
		int p4 = arr[0].length - 1;	//��ֹ��
		parttion(arr,list,p1,p2,p3,p4,p3,p4); //����������������ж����һ��ʱ�����ӡ�������Ҵ�ӡ
		return list;
	}
	
	private void parttion(int[][] arr, ArrayList<Integer> list, int p1, int p2,
			int p3, int p4, int p5, int p6) {
		if (p1 <= p3 && p2 <= p4) { //����ѭ��������
			//ֻ��һ��ʱ,��Ҫ�ж������ӡ�������Ҵ�ӡ
			if (p2 == p4) {
				if (p6 % 2 == 0) {
					for (int i = 0; i < p3 - p1 + 1; i++) {
						System.out.print(arr[p1 + i][p4]+" ");
						list.add(arr[p1 + i][p4]);
					}
				} else {
					for (int i = 0; i < p3 - p1 + 1; i++) {
						System.out.print(arr[p3 - i][p2]+" ");
						list.add(arr[p3 - i][p2]);
					}
				}
				return;
			}
			//ֻ��һ��ʱ.��Ҫ�ж������ӡ�������Ҵ�ӡ
			if (p1 == p3) { 
				if (p5 % 2 == 0) {
					for (int i = 0; i < p4 - p2 + 1; i++) {
						System.out.print(arr[p1][p2 + i]+" ");
						list.add(arr[p1][p2 + i]);
					}
				} else {
					for (int i = 0; i < p4 - p2 + 1; i++) {
						System.out.print(arr[p3][p4 - i]+" ");
						list.add(arr[p3][p4 - i]);
					}
				}
				return;
			}
			
			for (int i = 0; i < p4 - p2; i++) {
				System.out.print(arr[p1][p2 + i]+" ");
				list.add(arr[p1][p2 + i]);
			}
			for (int i = 0; i < p3 - p1; i++) {
				System.out.print(arr[p1 + i][p4]+" ");
				list.add(arr[p1 + i][p4]);
			}
			for (int i = 0; i < p4 - p2; i++) {
				System.out.print(arr[p3][p4 - i]+" ");
				list.add(arr[p3][p4 - i]);
			}
			for (int i = 0; i < p3 - p1; i++) {
				System.out.print(arr[p3 - i][p2]+" ");
				list.add(arr[p3 - i][p2]);
			}
			p1++;p2++;p3--;p4--;
			parttion(arr, list, p1, p2, p3, p4, p5, p6);
		}
	}

	//---------------------------------------------------------------------------------------
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);			//���ɵ���Ϊ�ڼ�����
			}
		}
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
