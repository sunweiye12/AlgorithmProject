package _03examination._1bytedance;
/*
 * 题目:两个完纸牌拉火车的游戏.初试给定两个人的牌,放到数组中,赢的牌放到一边,当两个人的手牌都没有时
 * 		看那个人赢的牌多,输出这个人的名字
 */
import java.util.ArrayList;
import java.util.List;

public class _06开火车纸牌游戏 {
	public static void main(String[] args) {
		int[] arr1 = {1,3,6,2,5,7,8,1};   //Byte的手牌
		int[] arr2 = {6,7,3,2,5,6,9,1};	//Dance的手牌
        parttion(arr1,arr2);
	}
	
	private static void parttion(int[] arr1, int[] arr2) {
		//arr1-->Byte     arr2-->Dance
		//两个人的个数
		int byteNum = 0;	
		int danceNum = 0;  
		//用于盛放纸牌的队列
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			//判断队列中是否含有该牌,没有返回-1,否则返回应该删除的个数
			int num1 = HasNum(list,arr1[i]);
			if(num1 == -1){ 	//没有此牌,加进去
				list.add(arr1[i]);
			}else { 			//有这张牌,将多余的牌拿走,并计数
				byteNum += num1+1;
				int tem = list.size();
				for (int j = 0; j < num1; j++) {
					list.remove(tem -1 - j);
				}
			}
			
			//轮到Dance放牌-->同理
			int num2 = HasNum(list,arr2[i]);
			if(num2 == -1){     
				list.add(arr2[i]);
			}else { 
				danceNum += num2+1;
				int tem = list.size();
				for (int j = 0; j <num2 ; j++) {
					list.remove(tem -1 - j);
				}
			}
		}
		System.out.println("Byte-->" + byteNum);
		System.out.println("Dance-->" + danceNum);
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
		return list.size() - j;
	}
}
