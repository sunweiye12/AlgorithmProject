package 欢乐颂._04二叉树;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Test;


public class _00二叉树 {
	@Test
	public void main() {
		Tree tree = new Tree();
		tree.add(0);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		//层次遍历
		tree.levelOrder(tree.head);
		//先序遍历
		tree.preOrder(tree.head);
		System.out.println("先序");
		tree.preOrder1(tree.head);
		System.out.println();
		//中序遍历
		tree.inOrder(tree.head);
		System.out.println("中序");
		tree.inOrder1(tree.head);
		System.out.println();
		//后序遍历
		tree.postOrder(tree.head);
		System.out.println("后序");
		tree.postOrder1(tree.head);
	}
	
	//创建树的节点对象
	class TreeNode{
		int val;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val){
			this.val = val;
		}
	}

	//一个树的类
	class Tree{
		public TreeNode head = null;	//存在一个结点元素
		
		/** 增加节点*/
		public void add(int item){
			TreeNode node = new TreeNode(item);
			if(head == null){
				head = node;
				return;
			}
			
			LinkedList<TreeNode> list = new LinkedList<TreeNode>(); //创建一个列表来存储元素
			list.add(head);		//每次追加到链表尾端
			while(list.size()!=0){
				TreeNode cur_node = list.getFirst();	//每次从头部获取(并删除)
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
		
		//层次遍历
		public void levelOrder(TreeNode root){
			if(root==null){
				return;
			}
			Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
			queue.add(root);
			while(queue.size() != 0){
				TreeNode cur_node = queue.poll();
				System.out.print(cur_node.val+" ");
				if(cur_node.left != null){
					queue.add(cur_node.left);
				}
				if(cur_node.right != null){
					queue.add(cur_node.right);
				}
			}
			System.out.println();
		}
		
		//前序遍历
		public void preOrder(TreeNode root){
			if (root!=null) {
				System.out.print(root.val+" ");
				preOrder(root.left);
				preOrder(root.right);
			}
		}
		//中序遍历
		public void inOrder(TreeNode root){
			if (root!=null) {
				inOrder(root.left);
				System.out.print(root.val+" ");
				inOrder(root.right);
			}
		}
		//后序遍历
		public void postOrder(TreeNode root){
			if (root!=null) {
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.val+" ");	
			}
		}

		//非递归前序遍历(*******************)
		public void preOrder1(TreeNode head){
			if(head!=null){ //如果不为空树进入
				//创建出一个栈结构
				Stack<TreeNode> stack=new Stack<TreeNode>();
				//将头部压栈
				stack.add(head);
			    while(!stack.isEmpty()){
			    	head=stack.pop();		//弹栈并打印栈顶元素
			        System.out.print(head.val+" ");
			        //如果栈顶有右孩子先压入,然后在判断左孩子压入
			        if(head.right != null) {
			        	stack.push(head.right); 	//在头部添加元素
			        }
			        if(head.left != null) {
			        	stack.push(head.left); 		//在头部添加元素
			        }
			    }
			}
		}
		
		//非递归中序遍历
		public void inOrder1(TreeNode head){
			if (head!=null) {
				//创建出一个栈结构
				Stack<TreeNode> stack=new Stack<TreeNode>();
				//当前节点不为空,当前压栈当前向左移动.当前节点为空,从栈中拿出一个作为当前并打印,当前节点向右移动
				while(!stack.isEmpty()||head!=null){	//如果当前不为空,或栈中还有元素则循环
					if(head!=null){	//当前节点不为空,当前压栈当前向左移动(相当于将所有左边界压入)
						stack.push(head); 	
						head=head.left;
					}else {			//当前节点为空,从栈中拿出一个作为当前并打印,当前节点向右移动
						head = stack.pop();
						System.out.print(head.val+" ");
						head=head.right;
					}		
				}
			}
		}
		
		//非递归后序遍历(双栈法)
		public void postOrder1(TreeNode head) {
		    //相当于相许遍历是中->左->右  你改为  中->右->左,并且不打印,然后将其加入辅助栈中,在弹栈时就实现了 左->右->中
			Stack<TreeNode> output = new Stack<TreeNode>(); //辅助栈呀
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(head);//将头部压栈
		    while(!stack.isEmpty()){
		    	head=stack.pop();		//弹栈并打印栈顶元素
		    	output.push(head);		//在原来改打印的时候进行压入栈辅助栈
		        //先压左孩子再压右孩子(*****和先序相反*****)
		        if(head.left != null) {
		        	stack.push(head.left); 	
		        }
		        if(head.right != null) {
		        	stack.push(head.right); 	
		        }
		    }
	        while (output.size() > 0) {
	           System.out.print(output.pop().val + " ");
	        }
		}
	}
}