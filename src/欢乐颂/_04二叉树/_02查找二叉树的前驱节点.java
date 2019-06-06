package 欢乐颂._04二叉树;


/**
 * 在二叉树中找到一个节点的前驱节点
	
	思路:可以分析,给你一个节点,如果此节点有左节点的话则其前驱节点为其左子树的最右节点
		如果此节点没有左子树的话-->此节点是不是父节点是右孩子,若是则后继节点为父节点,否则此节点和其父节点都指向其父节点(都想上移动)
		直到此节点为父节点的右孩子,则后继节点为此父节点
	
 * @author Administrator
 *
 */
public class _02查找二叉树的前驱节点 {
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

		Node test = head.left.left;  // 1's before is null(对于null元无法调用.value)
		System.out.println(test.value + " before: " + getSuccessorNode(test));
//		test = head.left.left.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.left;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.left.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.left.right.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.right.left.left;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.right.left;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " before: " + getSuccessorNode(test).value);
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
	
	//通过给定一个节点来获得其前驱节点
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.left != null) {	//如果其右子树不为空,返回右子树最左节点
			return getRightMost(node.left);
		} else {//如果右子树为空
			Node parent = node.parent;
			while (parent != null && parent.right != node) {  //parent != null是判空的逻辑 当没有后继的时候会向上parent指向空
				//两个同时指向其父节点(同时向上走一步)
				node = node.parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	public static Node getRightMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	
}
