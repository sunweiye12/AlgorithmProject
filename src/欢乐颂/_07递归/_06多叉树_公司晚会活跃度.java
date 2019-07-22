package 欢乐颂._07递归;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
* 递归来完成
 * 题目描述：一个公司的上下级关系是一棵多叉树，这个公司要举办晚会，
	  	你作为组织者已经摸清了大家的心理：一个员工的直接上级如果到场，这个员工肯定不会来。
	  	每个员工都有一个活跃度的值，决定谁来你会给这个员工发邀请函，怎么让晚会的气氛最活跃？
	  	返回最大的活跃值。	
 * 要求:给定一个多叉树的头结点.返回二叉树中的最大活跃值;
 * 
 * 用于解决所有二叉树的问题:
 * 	将问题分解:假如说给你一个头结点可能会存在一下情况
 * 		1.头结点来,如果头节点来的话所有子节点都不来,最大活跃值是头结点加上所有子节点不来的活跃值
 * 		2.头结点不来,子节点有可能来 也有可能不来,先判断每个子节点来与不来那个活跃值更高,选择高的那个将每个子节点累加起来
 * 	区分上面的情况所需要的信息:
 * 		1.当前节点来的活跃度
 * 		2.当前节点不来的活跃度
 * 	递归函数收集的信息
 * 		1.当前节点来的活跃度
 * 		2.当前节点不来的活跃度
 */
public class _06多叉树_公司晚会活跃度 {
	
	@Test
	public void main() {
		Node head = new Node(6); 
		head.list.add(new Node(3));
		head.list.add(new Node(3));
		head.list.add(new Node(2));
		head.list.add(new Node(4));
		System.out.println(Math.max(patition(head).bu_lai_huo, patition(head).lai_huo));
	}
	
	
	//创建一个返回值类型的类
	public class ReturnDate{
		public int lai_huo;
		public int bu_lai_huo;
		public ReturnDate(int lai_huo, int bu_lai_huo) {
			this.lai_huo = lai_huo;
			this.bu_lai_huo = bu_lai_huo;
		}
	} 
	
	public ReturnDate patition(Node head){
		//截止条件    //基础可能性分析
		if(head==null){return new ReturnDate(0, 0);}
		
		int cur_lai_huo = head.value;
		int cur_bu_lai_huo = 0;
		
		//递归函数(遍历子树达到返回值得到返回值)----> 递归的调用可以当做是黑盒
		for (int i = 0; i < head.list.size(); i++) {
			Node node = head.list.get(i);
			ReturnDate returnDate = patition(node);
			//由子节点来推导出当前节点,用来返回
			cur_lai_huo += returnDate.bu_lai_huo;	//领导来的话下属肯定不会来,因此加上他们都不来的活跃值
			cur_bu_lai_huo += Math.max(returnDate.lai_huo, returnDate.bu_lai_huo);//领导不来则下属可能来,也可能不来
		}
		//返回给自己的父调用
		return new ReturnDate(cur_lai_huo,cur_bu_lai_huo);
	}
	
	//创建树的节点对象
	class Node{
		int value;
		List<Node> list = null;
		public Node(int value){
			this.value = value;
			this.list = new LinkedList<Node>();
		}
	}
}

