package _02分类算法._09基础经典算法;

import java.util.Stack;

import org.junit.Test;

/**
 * 题目:定义二叉树的节点为:
 * 	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value){
			this.value = value;
		}
	}
	一个数组的MaxTree定义如下:
		数组必须没有重复元素,MaxTree是一课二叉树,数组的每一个值对应二叉树的节点,
		包括MaxTree二叉树在内还有它的每一个子树上最大值都是树的头 
	要求:给定一个没有重复元素的数组arr,写出生成这个二叉树的函数getMaxTree,返回树的头
	    并且时间复杂度为O(n)

	思路1:题目要求的是生成一个大根堆结构的二叉树,而建堆的过程正好是O(N)
	思路2:利用单调栈结构来完成将数组包装成为二叉树的节点,然后在放到一个数组中,进行单调栈操作
		找到没和节点左右两侧第一个比自己大大的节点:
			如果左右都为null,则其为头结点
			如果a左右只存在一个bia大的节点b,则让a成为b的孩子
			如果a左右存在连个b节点c,则让a成为b,c中较小的那个元素的孩子
	
 * @author Administrator
 *
 */
public class _10单调栈结构应用之生成二叉树 {

	@Test
	public void main() {
		int[] arr = generateRandomArray(7, 10);
//		int[] arr = {7,1,3,4,6,2,8};
		
		//思路1;通过堆结构来实现
		Node head = getMaxTreeByHeap(arr);
		Node head1 = getMaxTreeByStack(arr);
		
		printTree(head);
		printTree(head1);
		//打印二叉树
	}
	
	//思路2:通过单调栈来解决
	private Node getMaxTreeByStack(int[] arr) {
		Node[] nodeArr = new Node[arr.length];
		for (int i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = new Node(arr[i]);	//将每一个元素包装成节点存放到数组中
		}
		Stack<Integer> stack = new Stack<Integer>();	//创建一个单调栈(球附近大值-->原则从大到小(底到顶)
		//将每个元素都尝试放入栈中
		for (int i = 0; i < nodeArr.length; i++) {
			//当栈顶元素小于要放入的元素时弹栈操作
			while (!stack.isEmpty()&&nodeArr[stack.peek()].value < nodeArr[i].value) {
				//弹出当前元素并开始记录
				Node cur = nodeArr[stack.pop()];
				//如果空的话,说明左右只有一个,则认其为父
				if (stack.isEmpty()) {	
					if (nodeArr[i].left == null) {
						nodeArr[i].left = cur;
					} else{
						nodeArr[i].right = cur;
					}
					break;
				}
				//否则的话判断比较小的那个,指其为父
				Node minNode = nodeArr[i].value< nodeArr[stack.peek()].value ? nodeArr[i]:nodeArr[stack.peek()];
				if (minNode.left == null) {
					minNode.left = cur;
				} else{
					minNode.right = cur;
				}
			}
			//压入元素
			stack.push(i);
		}
		//所有元素都尝试压入后开始弹出元素
		while(!stack.isEmpty()){
			//弹出当前元素并开始记录(所有弹出都是因为上面为空)
			Node cur = nodeArr[stack.pop()];
			//如果空的话,说明左右左右都没了,他就是头结点
			if (stack.isEmpty()) {	
				return cur;
			} else{
				if (nodeArr[stack.peek()].left == null) {
					nodeArr[stack.peek()].left = cur;
				} else{
					nodeArr[stack.peek()].right = cur;
				}
			}
		}
		return null;
	}

	
	//思路1;给定一个数组,扮装成一个大根堆返回头部
	private Node getMaxTreeByHeap(int[] arr) {
		//BaseCase
		if (arr==null || arr.length == 0) {
			return null;
		}
		//实现建堆的过程
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			while (arr[index] > arr[(index-1)/2]) {   //如果我比父节点大则交换位置     (index-1)/2对应为index的父节点
				swap(arr,index,(index-1)/2); //交换两个元素
				index = (index-1)/2;
			}
		}
		
		printArr(arr);
		//次数数组已经成为二叉树乘次遍历的顺序,然后建立二叉树 (在数组中节点i其左孩子节点为2i+1 右孩子节点为2i+2)

		Node head = new Node(arr[0]);
		getTree(head, 0, arr);
		
		return head;
	}

	//给定一个节点和其所在的下标判断其有没有左右孩子,如果有的话就加上
	public void getTree(Node cur,int index,int[] arr){
		if (index>=arr.length) {
			return;
		}
		//说明有左节点
		if (2*index+1 < arr.length) { 
			cur.left = new Node(arr[2*index+1]);
		}
		getTree(cur.left, 2*index+1, arr);
		
		//说明有右节点
		if (2*index+2 < arr.length) { 
			cur.right = new Node(arr[2*index+2]);
		}
		getTree(cur.right, 2*index+2, arr);
	}
	



	//定义二叉树的节点为
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int value){
			this.value = value;
		}
	}
	
	
	//-----------------工具方法-------------------------------
	
	//生成长度随机的数组长度size 每个元素的值为 [-value , value]的数组
	public static int[] generateRandomArray(int size , int value){
		//生成长度随机的数组 长度处于[0 , size]
		//int[] arr = new int[(int)((size + 1) * Math.random())];
		int[] arr = new int[size];//指定长度
		
		for(int i =0;i < arr.length; i++){
			arr[i] = (int)((value + 1) * Math.random());
		}
		return arr;
	}
	//打印数组的方法
	private void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
	}
	//交换元素的位置
	private void swap(int[] arr, int index, int i) {
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}
	//直观打印二叉树
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
}
