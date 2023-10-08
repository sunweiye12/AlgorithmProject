package _04JianZhiOffer;
import org.junit.Test;
/*
 * ��Ŀ:����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * 		���������ǰ���������������Ľ���ж������ظ������֡�
 * 		��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 * 		���ؽ������������ء�
 * 
 * ˼·:���������������������,����ͨ������ĵ�һ�����ض�������ͷ���,
 * 		�õ�ͷ�ڵ��Ժ�,ͨ�����������һ������ֳ�������,�ֱ�ͷ����ߵ�������ұߵ�����,
 * 		ͬʱҲ���Խ���������ֳ�������,�ֱ�Ϊ�������������������
 * 		Ȼ����������ӽ������ӽڵ��Ӧ������,������ͬԭ��,���ظ���һ��
 */
public class _04�ؽ�������88 {
	
	@Test
	public void main() {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		Node head = reConstructBinaryTree(pre, in);
		printTree(head);  //ֱ�۴�ӡ������
		

	}
	public Node reConstructBinaryTree(int [] pre,int [] in) {
		if (pre==null || in==null || pre.length == 0 || in.length == 0) {
			return null;
		}
		Node head = getTreeHead(pre,0,pre.length-1,in,0,in.length-1); //�����������������
		
        return head;
    }
	
	//ͨ����������ͺ���,����ͷ�ڵ�
	public Node getTreeHead(int [] pre,int start1,int end1,int [] in,int start2,int end2){
		//BaseCase
		if (start1>end1||start2>end2) {
			return null;
		}
		
		Node head = new Node(pre[start1]);
		for(int i = start2; i <= end2 ;i++){
			if (in[i] == pre[start1]) { //��������˵���ҵ��������е��и��
				head.left = getTreeHead(pre, start1+1, start1+i-start2, in, start2, i-1);
				head.right = getTreeHead(pre, start1+i-start2+1, end1, in, i+1, end2);
				break;
			}
		}
		
		return head;
	}
		
	
	//-----------����-----------����-----------����-----------����--------
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}

	public void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public void printInOrder(Node head, int height, String to, int len) {
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

	public String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	
}
