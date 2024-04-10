package _04JianZhiOffer;

import java.util.LinkedList;

import org.junit.Test;

/*
 * 题目:环形约瑟夫问题,一共有n个人,人的编号为0~n-1,数数的间隔为m
 * 		返回最后一个人的时候,他的编号
 * 
 * 思路:顺序法,将每个数包装在链表中,然后依次数到m将其去除,然后在从m+1开始数到m在删除,直到最后剩余1个元素时
 * 思路:公式法,可以找到删除一个后和没有删除前每一个元素之间的坐标关系,
 * 		已知最后只剩一个时,此元素的下标一定为0,则通过他推出在两个元素时的下标,然后推出在三个元素时的下标,
 * 		直到推出其在n个元素时的下标即为所求
 */
public class _47孩子们的游戏_圆圈中最后剩下的数88 {

	@Test
	public void main() {
		int  res = LastRemaining_Solution(41, 3); //一共有5个人,报数3
		int  res1 = LastRemaining_jinjie1(41, 3); //一共有5个人,报数3
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
	
	//非递归版
	private int LastRemaining_jinjie1(int n, int m) {
		if(n <= 0 || m <= 0)
			return -1;
		if(n == 1){
			return 0; //如果只有一个人的haul就返回下标0
		}
		int ret = 0; //最后的剩余一个元素时下标为0-->然后反推出n个元素时其对应的坐标
		for(int i = 1;i < n; i++){	//推导n-1次
			int tem = (ret+m)%(i+1); //i+1个元素时所对应的下标为   --->  可以通过i元素所对应的下表推出其在i+1个元素时对应的下标
			ret = tem;
		}
		return ret;
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
