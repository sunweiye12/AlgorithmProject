package _1基本排序算法;

public class _01单链表 {
	public static void main(String[] args) {
		
//		Node node = new Node(1);
		MySingleLinkList sl = new MySingleLinkList();
		sl.addLast(1);
		sl.addLast(2);
		sl.addLast(3);
		sl.addLast(4);
		sl.addLast(5);
		sl.addIndex(3, 100);
		sl.removeFirst();
		sl.removeLast();
		sl.removeIndex(3);

		System.out.println(sl.Isempty());
		System.out.println(sl.Length());
		sl.travel();	
	}
	
	public static MySingleLinkList getLinked(){
		return new MySingleLinkList();
	}
}


/**创建一个节点
*/
class MyNode{
	public int elem;	//元素的值
	public MyNode next;	//元素的指针
	public MyNode(int elem){
		this.elem = elem;
	}
}

/**创建单向链表 */
class MySingleLinkList{
	 
	 public MyNode head = null;
	 public MySingleLinkList(){};
	 public MySingleLinkList(MyNode node){
		 this.head = node;
	 };
	 
	 //判断是否为空
	 public boolean Isempty(){
		 if(head == null){
			 return true;
		 } 
		 return false;
	 }
	
	 //链表长度
	 public int Length(){
		 MyNode cur = head;
		 int count = 0;
		 while(cur != null){
			 count += 1;
			 cur = cur.next;
		 }
		 return count;
	 }
	 
	 //遍历整个链表
	 public void travel(){
		MyNode cur = head;
        while (cur != null){
        	System.out.print(cur.elem +" ");
        	cur = cur.next;
        }
        System.out.println();
	 }
	 
	 //头部添加
	 public void add(int item){
		 MyNode node = new MyNode(item);
		 node.next = head;
		 head = node;
	 }
	 
	 //尾部添加
	 public void addLast(int item){
		 MyNode node = new MyNode(item);
		 MyNode cur = head;
		 if(cur == null){		//先判断头部节点是否为null
			 head = node;
			 return;
		 }
         while (cur.next != null){//遍历到最后一个节点
        	cur = cur.next;
         }
         cur.next = node;
	 }
	 
	 //指定索引位置添加
	 public void addIndex(int index,int item){
		 MyNode node = new MyNode(item);
		 MyNode cur = head;
		 int i = 0;
		 if(index <= 0){		
			 add(item);
			 return;
		 }
		 if(index >= Length()-1){		
			 addLast(item);
			 return;
		 }
		 while(i < index-1){
			 cur = cur.next;
			 i++;
		 }
		 node.next = cur.next;
		 cur.next = node;
	 }
	 
	 //头部删除
	 public void removeFirst(){
		 if(head==null){
			 return;
		 }
		 head= head.next;
	 }
	 
	 //尾部删除
	 public void removeLast(){
		 MyNode cur = head;
		 if(head==null){
			 return;
		 }
		 if(cur.next==null){
			 head = null;
			 return;
		 }
		 while(cur.next.next!=null){
			 cur = cur.next;
		 }
		 cur.next = null;
	 }
	 
	//指定索引位置删除
	 public void removeIndex(int index){
		 
		 MyNode cur = head;
		 int i = 0;
		 if(index <= 0){		
			 removeFirst();
			 return;
		 }
		 if(index >= Length()-1){		
			 removeLast();
			 return;
		 }
		 while(i < index-1){
			 cur = cur.next;
			 i++;
		 }
		 
		 cur.next = cur.next.next;
	 }	 
 }