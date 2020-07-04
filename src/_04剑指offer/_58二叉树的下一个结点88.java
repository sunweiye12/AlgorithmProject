package _04剑指offer;

/*
 * 题目:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 		注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 
 * 思路:该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设有一 棵Node类型的节点组成的二叉树，
	树中每个节点的parent指针都正确地指向 自己的父节点，头节点的parent指向null。
	现在只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。
	补充:在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点,node的前一个节点叫作node的前驱节点。
	
	思路1:因为此结构中含有parent指针因此可以通过给定的节点向上寻找到根节点,然后对二叉树进行中序遍历,从而可以得到此节点的后序节点
		此方案时间复杂度太高,要遍历整个二叉树
	
	思路2:可以分析,给你一个节点,如果此节点有右节点的话则其后续节点为其右子树的最左节点
		如果此节点没有右子树的话-->此节点是不是父节点是左孩子,若是则后继节点为父节点,
						  -->否则此节点和其父节点都指向其父节点(都想上移动)  直到此节点为父节点的左孩子,则后继节点为此父节点
 */
public class _58二叉树的下一个结点88 {

	public static void main(String[] args) {
		//构建一个二叉树
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;
		
		Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
	}
	//定义的二叉树
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int data) {
			this.value = data;
		}
	}
	
	//通过给定一个节点来获得其后续节点
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {//如果其右子树不为空,返回右子树最左节点
			return getLeftMost(node.right);
		} else {				//如果右子树为空
			Node parent = node.parent;
			while (parent != null && parent.left != node) {  //parent != null是判空的逻辑 当没有后继的时候会向上parent指向空
				//如果在为父节点的右孩子使,两个同时指向其父节点(同时向上走一步)
				node = node.parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	//---------------------------------------------------------------------------------------------
	
}
