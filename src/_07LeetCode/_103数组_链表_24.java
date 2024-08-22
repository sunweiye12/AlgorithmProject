package _07LeetCode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 * 问细节:每隔两个交换一次,奇数个的时候最后一个不交换,1也元素或者为空时不交换.
 *
 * 思路1: 每两个元素执行一次操作
 *
 * 指针cur 代表当前两个元素中的第一个元素
 * 指针pev 代表的是上面两个元素中的第二个元素
 *
 * 初始化:
 * 1. cur为head.next.next
 * 2. 将第二个元素作为头,下一个节点指向第一个元素,pev指向这个元素,并让这个元素的next为空
 * 3. 判断cur
 */

public class _103数组_链表_24 {

    @Test
    public void main() {
        System.out.println("开始");

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode ret = swapPairs(listNode1);
        System.out.println(ret);

    }

    public ListNode swapPairs(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) return head;
        // 获取第二个元数作为起始元数
        ListNode next = head.next;
        // head往下走两步递归,并将返回的结果放到head.next
        head.next = swapPairs(head.next.next);
        // 将第二个节点和第一个节点连接
        next.next = head;
        return next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;

        // 保存第三个元素
        ListNode cur = head.next.next;
        // 初始化前两个元素
        ListNode pev = head; // 代表前两个元素的第二个元素
        ListNode rs = head.next; // 结果

        rs.next = pev;
        pev.next = null; // 重点

        while (cur != null) {
            if (cur.next != null) {
                // 保留元素
                ListNode a  = cur;
                ListNode b  = cur.next;

                // 要先更新索引(要不然下卖弄赋值的时候会成环)
                cur = cur.next.next;

                // 执行交换
                pev.next = b;
                pev.next.next = a;

                // 更新索引
                pev = a;
                pev.next = null;
            } else {
                pev.next = cur;
                cur = cur.next;
            }
        }

        return rs;
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