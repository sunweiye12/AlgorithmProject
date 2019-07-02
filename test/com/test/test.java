package _1bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String[] sArr1 = line1.split(" ");
        String[] sArr2 = line2.split(" ");
        int[] arr1 = new int[sArr1.length];
        int[] arr2 = new int[sArr2.length];
        for (int i = 0; i < arr1.length; i++) {
        	arr1[i] = Integer.parseInt(sArr1[i]); // 将数字字符串转换成数字
        	arr2[i] = Integer.parseInt(sArr2[i]); // 将数字字符串转换成数字
        }
        parttion(arr1,arr2);
	}
	private static void parttion(int[] arr1, int[] arr2) {
		int byteNum = 0;	
		int danceNum = 0;  
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			if(HasNum(list,arr1[i])==-1){    
				list.add(arr1[i]);
			}else {
				int num1 = HasNum(list,arr2[i]);
				byteNum += num1+1;
				int tem = list.size();
				for (int j = 0; j < num1; j++) {
					list.remove(tem -1 -j);
				}
			}
			if(HasNum(list,arr2[i])==-1){     
				list.add(arr2[i]);
			}else { 
				int num2 = HasNum(list,arr2[i]);
				danceNum += num2+1;
				int tem = list.size();
				for (int j = 0; j <num2 ; j++) {
					list.remove(tem -1 -j);
				}
			}
		}
		if (byteNum == danceNum) {
			System.out.println("Draw");
			return;
		} else if(byteNum > danceNum){
			System.out.println("Byte");
			return;
		} else {
			System.out.println("Dance");
		}
	}
	private static int HasNum(List<Integer> list, int i) {
		if (!list.contains(i)) {
			return -1;
		}
		int j = 0;
		while(list.get(j) != i){
			j++;
		}
		return list.size()-j;
	}
}
