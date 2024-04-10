package _04JianZhiOffer;

/*
 * ��Ŀ:����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * 		ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 * 
 * ˼·:�ýṹ����ͨ�������ڵ�ṹ����һ��ָ�򸸽ڵ��parentָ�롣������һ ��Node���͵Ľڵ���ɵĶ�������
	����ÿ���ڵ��parentָ�붼��ȷ��ָ�� �Լ��ĸ��ڵ㣬ͷ�ڵ��parentָ��null��
	����ֻ��һ���ڶ������е�ĳ���ڵ� node����ʵ�ַ���node�ĺ�̽ڵ�ĺ�����
	����:�ڶ���������������������У� node����һ���ڵ����node�ĺ�̽ڵ�,node��ǰһ���ڵ����node��ǰ���ڵ㡣
	
	˼·1:��Ϊ�˽ṹ�к���parentָ����˿���ͨ�������Ľڵ�����Ѱ�ҵ����ڵ�,Ȼ��Զ����������������,�Ӷ����Եõ��˽ڵ�ĺ���ڵ�
		�˷���ʱ�临�Ӷ�̫��,Ҫ��������������
	
	˼·2:���Է���,����һ���ڵ�,����˽ڵ����ҽڵ�Ļ���������ڵ�Ϊ��������������ڵ�
		����˽ڵ�û���������Ļ�-->�˽ڵ��ǲ��Ǹ��ڵ�������,�������̽ڵ�Ϊ���ڵ�,
						  -->����˽ڵ���丸�ڵ㶼ָ���丸�ڵ�(�������ƶ�)  ֱ���˽ڵ�Ϊ���ڵ������,���̽ڵ�Ϊ�˸��ڵ�
 */
public class _58����������һ�����88 {

	public static void main(String[] args) {
		//����һ��������
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
	//����Ķ�����
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int data) {
			this.value = data;
		}
	}
	
	//ͨ������һ���ڵ������������ڵ�
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {//�������������Ϊ��,��������������ڵ�
			return getLeftMost(node.right);
		} else {				//���������Ϊ��
			Node parent = node.parent;
			while (parent != null && parent.left != node) {  //parent != null���пյ��߼� ��û�к�̵�ʱ�������parentָ���
				//�����Ϊ���ڵ���Һ���ʹ,����ͬʱָ���丸�ڵ�(ͬʱ������һ��)
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
