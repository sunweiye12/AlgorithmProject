package 欢乐颂._04二叉树;


/**
 * 
 * 已知一棵完全二叉树，求其节点的个数
 * 
 * 要求：时间复杂度**低于**O(N),其中N为这棵树的节点个数
 * 
 * 思路:对于高度为h的满二叉树.其节点总数为2^h-1
 * 		1.判断左子树的高度和右子树的高度是否相同(因为是满二叉树,可以通过不断向左遍历实现)
 * 		2.-->如果相等,说明左子树一定满二叉树,直接调用公式可以得到左子树的节点数,然后再将head置为右节点
 * 		3.-->如果不相等,则一定是做子树比右子树大1,说明右子树一定满二叉树,直接调用公式可以得到右子树的节点数,然后再将head置为左节点
 */
public class _08求完全二叉树节点数 {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(1);
		mytree.add(2);
		mytree.add(3);
		mytree.add(4);
		mytree.add(5);
		mytree.add(6);
		mytree.add(7);
		mytree.add(8);
		mytree.add(9);
		mytree.add(10);
		int size = getSize(mytree.head);
		System.out.println(size);
//		System.out.println(getHight(mytree.head));
	}
	
	//获取此二叉树的节点数
	private static int getSize(Node head) {
		if (head==null) {	return 0;	}	//空节点为0
		if (head.left==null&&head.right==null) {	return 1;	} //只有head节点为1
		if (head.left!=null&&head.right==null) {	return 2;	} //只有左节点为2
		
		int lefth = getHight(head.left);
		int righth = getHight(head.right);
		
		if (lefth==righth) {
			return (int)(Math.pow(2, lefth))+ getSize(head.right);
		}else {
			return (int)(Math.pow(2, righth))+ getSize(head.left);
		}
	}
	
	//在完全二叉树中获取一个数的高度(直接向左遍历)
	private static int getHight(Node head) {
		int resut = 0;
		while(head!=null){
			resut++;
			head=head.left;
		}
		return resut;
	}

	
}
