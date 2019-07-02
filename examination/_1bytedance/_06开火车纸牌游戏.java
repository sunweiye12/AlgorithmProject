package _1bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06开火车纸牌游戏 {
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in); //等待输入信息
//		//1.读取一行的字符串
//        String line1 = sc.nextLine();
//        String line2 = sc.nextLine();
//        //2.将字符串切割成字符数组
//        String[] sArr1 = line1.split(" ");
//        String[] sArr2 = line2.split(" ");
//        //3.创建int数组,将字符数组转型存放到int数组中
//        int[] arr1 = new int[sArr1.length];
//        int[] arr2 = new int[sArr2.length];
//        for (int i = 0; i < arr1.length; i++) {
//        	arr1[i] = Integer.parseInt(sArr1[i]); // 将数字字符串转换成数字
//        	arr2[i] = Integer.parseInt(sArr2[i]); // 将数字字符串转换成数字
//        }
		int[] arr1 = {1,1,5};
		int[] arr2 = {6,10,1};
        parttion(arr1,arr2);
	}
	private static void parttion(int[] arr1, int[] arr2) {
		//arr1-->byte     arr2-->dance
		//两个人的个数
		int byteNum = 0;	
		int danceNum = 0;  
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			if(HasNum(list,arr1[i])==-1){ //判断队列中是否含有,没有返回-1,否则返回距离头结点的个数
				list.add(arr1[i]);
			}else { 	//拿走那些牌
				int num1 = HasNum(list,arr2[i]);
				byteNum += num1+1;
				int tem = list.size();
				for (int j = 0; j < num1; j++) {
					list.remove(tem -1 -j);
				}
			}
			
			if(HasNum(list,arr2[i])==-1){     //判断队列中是否含有,没有返回-1,否则返回距离头结点的个数
				list.add(arr2[i]);
			}else { //拿走那些牌
				int num2 = HasNum(list,arr2[i]);
				danceNum += num2+1;
				int tem = list.size();
				for (int j = 0; j <num2 ; j++) {
					list.remove(tem -1 -j);
				}
			}
		}
//		System.out.println("Byte-->" +byteNum);
//		System.out.println("Dance-->" +danceNum);
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
	//如果list中包含i则返回,他的距离斗节点的位置,否则返回-1
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
