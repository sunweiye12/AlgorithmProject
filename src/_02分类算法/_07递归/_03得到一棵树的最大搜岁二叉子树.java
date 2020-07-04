package _02分类算法._07递归;

import java.util.LinkedList;

import org.junit.Test;

/*
 * 递归来完成
 * 题目:给定一个二叉树的头结点.返回二叉树中的最大二叉子树
 * 
 * 用于解决所有二叉树的问题:
 * 	将问题分解:假如说给你一个头结点可能会存在一下情况
 * 		1.最大搜索子树来自左子树
 * 		2.最大搜索子树来自右子树
 * 		3.自己为头的树可能就是搜索二叉树(左树搜索二叉树的头为左孩子,右树搜索二叉树的头为右孩子,左树最大值小于head.val小于右树的最小值)
 * 
 * 	我们进行是那个面的分解所需要的条件:
 * 		1.左树搜索二叉子树的大小
 * 		2.右树搜索二叉子树的大小
 * 		3.左树搜索二叉子树的头(用于和head.left比较)
 * 		4.右树搜索二叉子树的头(用于和head.right比较)
 * 		5.左树的最大值
 * 		6.右树的最小值	(用于判断情况三)
 * 
 * 	化简为每次递归函数主要返回的参数:
 * 		1.此节点为头的子节点搜索二叉子树的大小
 * 		2.此节点为头的子节点搜索二叉子树的头
 * 		3.此节点为头二叉树最大值
 * 		4.此节点为头二叉树最小值
 */

public class _03得到一棵树的最大搜岁二叉子树 {
	@Test
	public void main() {
		Tree mytree = new Tree(); 
		mytree.add(5);
		mytree.add(3);
		mytree.add(8);
		mytree.add(1);
		mytree.add(4);
		mytree.add(7);
		mytree.add(1);

		System.out.println(patition(mytree.head).size);
	}
	
	
	//创建一个返回值类型的类
	public class ReturnDate{
		int size;
		Node head;
		int max; 
		int min;
		public ReturnDate(int size, Node head, int max, int min) {
			this.size = size;
			this.head = head;
			this.max = max;
			this.min = min;
		}
	} 
	
	public ReturnDate patition(Node head){
		//递归截止条件
		if (head == null) {
			return new ReturnDate(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		//递归函数(假设左树环额右树都能得到返回值)----> 递归的调用可以当做是黑盒
		Node left = head.left;
		ReturnDate leftReturnDate = patition(left);		//左子树返回值
		Node right = head.right;
		ReturnDate rightReturnDate = patition(right);	//右子树返回值
		
		//得到左右两边的返回值以后开始找出当前节点的信息返回给父
		//如果是第三种情况(得到最大搜索二叉树的大小)
		int includeItSelf = 0; //当前节点为平衡二叉树时的大小
		if (head.left == leftReturnDate.head 
				&& head.right == rightReturnDate.head
				&& leftReturnDate.max < head.value
				&& head.value < rightReturnDate.min) {
			includeItSelf = rightReturnDate.size + leftReturnDate.size + 1;
		}
		
		int p1 = leftReturnDate.size;
		int p2 = rightReturnDate.size;
		
		int maxsize = Math.max(Math.max(p1, p2), includeItSelf); //获取到做大的二叉树个数
		Node maxHead = p1 > p2 ? leftReturnDate.head : rightReturnDate.head;
		maxHead = maxsize == includeItSelf ? head : maxHead;
		int max = Math.max(head.value, Math.max(leftReturnDate.max, rightReturnDate.max));
		int min = Math.min(head.value, Math.min(leftReturnDate.min, rightReturnDate.min));
		
		return new ReturnDate(maxsize, maxHead, max, min);
	}


	//------------------------------工具类--------------------------------------------------------
	//创建树的节点对象
	class Node{
		int value;
		Node left = null;
		Node right = null;
		public Node(int val){
			this.value = val;
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
