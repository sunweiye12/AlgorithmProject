package 欢乐颂._04二叉树;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 * 折纸问题
	【题目】 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。
	此时 折痕是凹下去的，即折痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2 次，
	压出折痕后展开，此时有三条折痕，从上到下依次是下折痕、下折痕和上折痕。
	给定一 个输入参数N，代表纸条都从下边向上方连续对折N次，
	请从上到下打印所有折痕的方向。 
	例如： N=1时，打印： down 
		 N=2时，打印： down down up
		 
	思路:可将此问题转化为为二叉树的中序遍历
		有规律可以得出对于折叠3次,其结果为
					down
 *		down					up
 *down			up		 down		up
 *其中序遍历的结果即为所求
 *1.首先构建一个二叉树节点,节点的value存储down或up
 *2.定义头结点为down.对于一个节点如果其有子节点,则左子为down,右子为up
 *3.折纸的次数,就是此二叉树的高度
 */
public class _04折纸问题 {
	
	@Test
	public void main() {
		int N = 4;
		printAllFolds(N);
		System.out.println();
		printAllFolds1(N);
	}
	
	//打印n层的二查树
	private void printAllFolds1(int n) {
		//创建一个n层的二叉树,返回头结点
		Node head = createTree(n);
		inOrder(head);		
	}
	
	//中序遍历
	public void inOrder(Node head){
		if (head!=null) {
			inOrder(head.left);
			System.out.print(head.value+" ");
			inOrder(head.right);
		}
	}
	
	//创建一个n层的二叉树,返回头结点
	private Node createTree(int n) {
		if (n==0) {
			return null;
		}
		
		Node head = new Node("down");	//创建一个头节点
		//构建两个队列一个存放本层节点.另一个存放下一层节点
		Queue<Node> curQueue = new LinkedList<Node>();	//存放当前行的元素
		Queue<Node> nextQueue = new LinkedList<Node>();	//存放下一行的元素
		curQueue.add(head);
		int count = 1;
		while(count<n) {
			while(!curQueue.isEmpty()){
				Node cur = curQueue.poll();
				cur.left = new Node("down");
				cur.right = new Node("up");
				nextQueue.add(cur.left);
				nextQueue.add(cur.right);
			}
			count++;
			curQueue.addAll(nextQueue);	//将nextQueue队列中的元素放到curQueue中
			nextQueue.clear();
		}
		return head;
	}

	//自定义二叉树节点
	private class Node{
		public String value;
		public Node left;
		public Node right;
		public Node(String value){
			this.value=value;
		}
	}
	
//--------------------------------------------方法2---------------------------------------------

	public void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	public void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.print(down ? "down " : "up " +" ");
		printProcess(i + 1, N, false);
	}

	
}
