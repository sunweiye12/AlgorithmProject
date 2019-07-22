package 欢乐颂._03链表;

import org.junit.Test;


/*
 * 打印两个有序链表的公共部分
	【题目】 给定两个有序链表的头指针head1和head2，(**有序链表--默认从小到大)
	               打印两个链表的公共部分。
	思路:荷兰国旗问题 
 */
public class _01打印两个有序链表的公共部分 {
	
	@Test
	public void main() {
		MySingleLinkList my1 = new MySingleLinkList();
		MySingleLinkList my2 = new MySingleLinkList();
		my1.addLast(1);
		my1.addLast(2);
		my1.addLast(3);
		my1.addLast(4);
		my2.addLast(1);
		my2.addLast(3);
		my2.addLast(4);
		my2.addLast(5);
		my2.addLast(6);
		MyNode head1 = my1.head;
		MyNode head2 = my2.head;
		printLinklist(head1,head2);
	}
	
	public void printLinklist(MyNode head1,MyNode head2){
		while(head1!=null && head2!=null){
			if (head1.elem>head2.elem) {
				head2=head2.next;
			} else if(head1.elem<head2.elem) {
				head1=head1.next;
			} else {
				System.out.print(head1.elem+" ");
				head1=head1.next;
			}
		}
	}
}



//工具类-----工具类-------工具类------工具类------工具类---------工具类------------工具类-------------工具类-------工具类---
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