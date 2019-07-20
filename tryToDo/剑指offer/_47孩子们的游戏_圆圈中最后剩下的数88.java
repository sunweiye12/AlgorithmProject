package 剑指offer;

import java.util.LinkedList;

import org.junit.Test;

/*
 * 题目:环形约瑟夫问题,一共有n个人,人的编号为0~n-1,数数的间隔为m
 * 		返回最后一个人的时候,他的编号
 */
public class _47孩子们的游戏_圆圈中最后剩下的数88 {

	@Test
	public void main() {
		int  res = LastRemaining_Solution(41, 3); //一共有5个人,报数3
		int  res1 = LastRemaining_jinjie(41, 3); //一共有5个人,报数3
		System.out.println(res);
		System.out.println(res1);
	}
	
	//进阶解决方案(返回n个人中,数m,最后剩下人的坐标)
	private int LastRemaining_jinjie(int n, int m) {
		if(n <= 0 || m <= 0)
			return -1;
		if(n == 1){
			return 0; //如果只有一个人的haul就返回下标0
	   	}
	 	return (LastRemaining_Solution(n-1, m)+m)%n;
	}

	//通过链表来模拟游戏过程
	public int LastRemaining_Solution(int n, int m) {
		//basecase
		if (n<=0 || m<=0) {
			return -1;
		}
		//链表效率高
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < n; i ++) { //下标为0~n-1
		    list.add(i); 	//将元素都添加大链表中
		}
		int bt = 0; 		//从第0个位置开始计时
		while (list.size() > 1) {
		    bt = (bt + m - 1) % list.size(); //每次要杀死的人下标
		    list.remove(bt); 	//删除下标
		}
		return list.get(0);		//返回最后剩余的元素
    }
}
