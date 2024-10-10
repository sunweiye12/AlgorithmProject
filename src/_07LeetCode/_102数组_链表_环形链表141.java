package _07LeetCode;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/
 * 问细节:当只有一个节点,或者为null的时候,认为是又环还是没有环?
 *
 * 思路1: 通过set结构来实现,从头开始遍历,将每一个元素判断set是否存在并扔到set,
 *  如果set中始终没有重复数据则说明没有环.否则就有环. 时间O(n) 空间O(n)
 *
 * 思路2: 通过快慢指针是实现,两个指针开始都指向head,慢指针一次走一步,块指针一次走两步,
 * 如果在发现终点之前两个相遇了,则说明又环.
 *
 */

public class _102数组_链表_环形链表141 {

    @Test
    public void main() {
        System.out.println("开始");

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        Boolean ret = hasCycle1(listNode1);
        System.out.println(ret);

    }

    public Boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set= new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
                head = head.next;
            } else {
                return true;
            }
        }
        return false;
    }

    public Boolean hasCycle2(ListNode head) {

        ListNode low = head;
        ListNode higt = head;
        while (low != null && higt != null && higt.next != null){
            low = low.next;
            higt = higt.next.next;
            if (low == higt) return true;
        }
        return false;
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