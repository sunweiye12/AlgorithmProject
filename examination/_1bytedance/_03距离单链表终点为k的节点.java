package _1bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * 题目:输入一共有num加2行,每行一个数,第一个数是num
 * 		接下来有num行和随机数
 * 		最后一行的数代表,你最后输出这num行中的第几个数(从下往上数)
 * 
 * 思路:将有效数放到一个集合中中,然后拿出第几数
 */
public class _03距离单链表终点为k的节点 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);	
		int num = 2;
		printIndexNum(list,num);
	}

	public static void printIndexNum(ArrayList<Integer> list, int num) {
		//basecase
		if (num >= list.size() || num < 0) {
			System.out.println("null");
			return;
		}
		System.out.println(list.get(list.size() - 1 -num));
	}
}
