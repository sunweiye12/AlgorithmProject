package 欢乐颂._07递归;

import java.util.LinkedList;

import org.junit.Test;

import 欢乐颂._07递归._03得到一棵树的最大搜岁二叉子树.Node;
import 欢乐颂._07递归._03得到一棵树的最大搜岁二叉子树.ReturnDate;

/**
* 递归来完成
 * 题目:二叉树中,一个节点可以往上走也可以往下走.那么节点A总能走到节点B
 * 		节点A走到节点B的距离为:A走到B左端路径上的节点个数,一颗二叉树的最远距离
 * 
 * 要求:给定一个二叉树的头结点.返回二叉树中的最大距离;
 * 
 * 用于解决所有二叉树的问题:
 * 	将问题分解:假如说给你一个头结点可能会存在一下情况
 * 		1.最大距离可能来自左子树
 * 		2.最大距离可能来自右子树
 * 		3.最大距离可能来自左树最下层的节点到头结点的距离加上右树最下层的节点到头结点的距离
 * 	区分上面的情况所需要的信息:
 * 		1.左子树的最大距离
 * 		2.右子树的最大距离
 * 		3.左子树的深度
 * 		4.右子树的深度
 * 	递归函数收集的信息
 * 		1:当前子树中的最大距离
 * 		2.当前子树的深度
 */
public class _05二叉树两个节点的最大距离 {
	
	@Test
	public void main() {
		Tree mytree = new Tree(); 
		mytree.add(5);
		mytree.add(3);
		mytree.add(8);
		mytree.add(1);
		mytree.add(4);
		mytree.add(7);
		System.out.println(patition(mytree.head).maxLen);
	}
	
	
	//创建一个返回值类型的类
	public class ReturnDate{
		public int maxLen;
		public int h;
		public ReturnDate(int maxLen, int h) {
			this.maxLen = maxLen;
			this.h = h;
		}
	} 
	
	public ReturnDate patition(Node head){
		//截止条件    //基础可能性分析
		if(head==null){return new ReturnDate(0, 0);}	
		
		//递归函数(假设左树环额右树都能得到返回值)----> 递归的调用可以当做是黑盒
		Node left = head.left;
		ReturnDate leftReturnDate = patition(left);		//左子树返回值
		Node right = head.right;
		ReturnDate rightReturnDate = patition(right);	//右子树返回值
		
		//得到左右两边的返回值以后开始找出当前节点的信息返回给父
		
		int curh = Math.max(leftReturnDate.h, rightReturnDate.h) + 1;
		int curmaxLen = leftReturnDate.h + rightReturnDate.h + 1;
		curmaxLen = Math.max(Math.max(leftReturnDate.maxLen,rightReturnDate.maxLen), curmaxLen);
		
		//返回给自己的父调用
		return new ReturnDate(curmaxLen,curh);
	}
	//创建树的节点对象
	class Node{
		int val;
		Node left = null;
		Node right = null;
		public Node(int val){
			this.val = val;
		}
	}

	//一个树的类
	class Tree{
		public Node head = null;	//存在一个结点元素
		
		//添加元素(层级添加)
		public void add(int item){
			Node node = new Node(item);
			if(head == null){
				head = node;
				return;
			}
			
			LinkedList<Node> list = new LinkedList<Node>(); //创建一个列表来存储元素
			list.add(head);		//每次追加到链表尾端
			while(list.size()!=0){
				Node cur_node = list.getFirst();	//每次从头部获取(并删除)
				list.removeFirst();
				if(cur_node.left == null){
					cur_node.left = node;
					return;
				} else {
					list.add(cur_node.left);
				}
				
				if(cur_node.right == null){
					cur_node.right = node;
					return;
				} else {
					list.add(cur_node.right);
				}
			}
		}
	}
}

