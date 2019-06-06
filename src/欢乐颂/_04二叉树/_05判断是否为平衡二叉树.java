package 欢乐颂._04二叉树;

import java.util.LinkedList;

/**
 * 平衡二叉树:任何一个节点的左子树高度与其小右子树高度相差不超过一
 * 
 * 大流程:每一个子节点都是平衡树,整个才能是平衡树(因此要过所有节点)
 * 分析:假设遍历到某一个节点所需要收集的信息有:
 * 									1.左树是否平衡	(不平整个就不是)
 * 									2.右树是否平衡  (不平整个就不是)
 *									3.左树高度	(左右都平判断左右高度)
 *									4.右树高度
 *			存在的可能性:1.左树不平衡---->返回 false
 *					  2.右树不平衡---->返回fasle
 *					  3.若左树和右树都平衡且高度差大于1---->返回fasle
 *					  4.否则---->返回true
 *			因此:所以在调用递归时返回值的信息有,此树是否平衡和次数高度
 */
public class _05判断是否为平衡二叉树 {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(1);
		mytree.add(1);
		mytree.add(1);
		mytree.add(1);
//		mytree.add(1);
//		mytree.add(1);
//		mytree.add(1);
//		mytree.add(1);
		System.out.println(patition(mytree.head).isB);
	}
	//创建一个返回值类型的类
	public static class ReturnDate{
		public boolean isB;
		public int h;
		public ReturnDate(boolean isB, int h) {
			this.isB = isB;
			this.h = h;
		}
	} 
	
	public static ReturnDate patition(Node head){
		if(head==null){return new ReturnDate(true, 0);}	//基础可能性分析
		
		//假设能够收到左树的返回值
		ReturnDate leftDate = patition(head.left);
		if (!leftDate.isB) {	//左树不为平衡直接返回false
			return new ReturnDate(false, 0);
		}
		//右树相同的逻辑
		ReturnDate rightDate = patition(head.right);
		if (!rightDate.isB) {	//左树不为平衡直接返回false
			return new ReturnDate(false, 0);
		}
		//走到这步说明左树和右树都平衡.判断左树和右树的高度差是否大于1
		if (Math.abs(leftDate.h-rightDate.h)>1) {
			return new ReturnDate(false, 0);
		}
		//走到这说明左右书都平衡且高度差小于2,应该返回true和树的高度
		return new ReturnDate(true, Math.max(leftDate.h, rightDate.h)+1);
	}
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