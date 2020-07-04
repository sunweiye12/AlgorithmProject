package _02分类算法._04二叉树;

import java.util.Stack;


/**
 * 搜索二叉树:任何一个节点的左子树比其小右子树比其大
 * 
 * 思路:中序遍历都是升序的,因此可以通过修改中序遍历来实现
 * 		1.进行中序遍历,将遍历后的结果装到集合中,
 * 		2.判断集合元素是不是升序的
 *	思路2:在遍历是记录上一个元素,如果下一个元素都大于上一个元素则返回true
 *			否则返回false
 *	思路3:设置一个最小值,每次遍历时如果当前值大于min就将min置为当前值继续	
 *							如果当前值小于min说明不是升序操作返回false
 */
public class _06判断是否为搜索二叉树 {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(4);
		mytree.add(2);
		mytree.add(6);
		mytree.add(1);
		mytree.add(9);
		mytree.add(5);
		mytree.add(7);
		boolean b = isBalanceTree(mytree.head);
		System.out.println(b);
	}
	
	//返回是否为搜索二叉树
	public static boolean isBalanceTree(Node head){
		if (head==null) {
			return true;
		}
		int min = Integer.MIN_VALUE; //用于判断是否为升序
		Stack<Node> stack = new Stack<Node>();
		while (head!=null || !stack.isEmpty()) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			} else{
				head = stack.pop();
				if (head.val > min) {
					min = head.val;
				} else {
					return false;	//判断两个集合的顺序是否相同
				}
//				System.out.println(head.val);
				head = head.right;
			}
		}
		return true;	//判断两个集合的顺序是否相同
	}
	
	
}
