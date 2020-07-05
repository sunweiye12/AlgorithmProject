package _05LeetCode;

import _00工具箱类._07单向链表;
import org.junit.Test;

/*
题目要求:
给出两个?非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只
能存储?一位?数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0?开头。

注:因为链表可以无限长,因此不能将其转变为int后处理,因为可能会存在越界异常
*/
public class _01两数相加 {

    //定义节点
    class ListNode {
        public int val;    //元素的值
        public ListNode next;    //元素的指针

        public ListNode(int elem) {
            this.val = elem;
        }
    }

    //定义打印链表的方法
    private void printLinkList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "-");
        printLinkList(head.next);
    }

    @Test
    public void main() {
        //创建单向链表
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        printLinkList(list1);
        System.out.println();

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        printLinkList(list2);
        System.out.println();

        printLinkList(addTwoNumbers(list1, list2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       // 创建根目录
        ListNode root = new ListNode(0);
        ListNode curNode = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry !=0) {
            int var1 = l1 == null? 0 : l1.val;
            int var2 = l2 == null? 0 : l2.val;
            curNode.next = new ListNode((var1 + var2 + carry)%10);
            curNode = curNode.next;
            carry = (var1 + var2 + carry)>=10? 1 : 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
}