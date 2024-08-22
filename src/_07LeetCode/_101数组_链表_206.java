package _07LeetCode;
import org.junit.Test;

/**
 * 链接：https://leetcode.cn/problems/reverse-linked-list/description/
 * 问细节: 链表中不能有环
 *
 * 思路1:
 * 1. 利用三个指针,分别指向上一个元素pev,当前元素cur,下一个元素net
 * 初始状态：1）prv为空 2）cur为head
 * 当cur不为空的时候遍历：
 *  1)保存net指针为cur.next (临时变量)
 *  2)将cur.next指向pev.
 *  3)更新pev和cur的指针
 */

public class _101数组_链表_206 {

    @Test
    public void main() {
        System.out.println("开始");

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode ret = reverseList(listNode1);
        printNode(ret);

    }

    public ListNode reverseList(ListNode head) {
        ListNode pev = null;
        ListNode cur = head;
        while (cur != null) {
            // 保存中间变量
            ListNode net = cur.next;
            // 将next指针指向前一个
            cur.next = pev;

            //更新指针
            pev = cur;
            cur = net;
        }
        return pev;
    }

    public void printNode(ListNode head) {
        ListNode headTmp = head;
        while (headTmp != null) {
            System.out.println(headTmp.val);
            headTmp = headTmp.next;
        }
    }

    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}