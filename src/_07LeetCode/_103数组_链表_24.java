package _07LeetCode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 * ��ϸ��:ÿ����������һ��,��������ʱ�����һ��������,1ҲԪ�ػ���Ϊ��ʱ������.
 *
 * ˼·1: ÿ����Ԫ��ִ��һ�β���
 *
 * ָ��cur ����ǰ����Ԫ���еĵ�һ��Ԫ��
 * ָ��pev ���������������Ԫ���еĵڶ���Ԫ��
 *
 * ��ʼ��:
 * 1. curΪhead.next.next
 * 2. ���ڶ���Ԫ����Ϊͷ,��һ���ڵ�ָ���һ��Ԫ��,pevָ�����Ԫ��,�������Ԫ�ص�nextΪ��
 * 3. �ж�cur
 */

public class _103����_����_24 {

    @Test
    public void main() {
        System.out.println("��ʼ");

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode ret = swapPairs(listNode1);
        System.out.println(ret);

    }

    public ListNode swapPairs(ListNode head) {
        // �ݹ���ֹ����
        if (head == null || head.next == null) return head;
        // ��ȡ�ڶ���Ԫ����Ϊ��ʼԪ��
        ListNode next = head.next;
        // head�����������ݹ�,�������صĽ���ŵ�head.next
        head.next = swapPairs(head.next.next);
        // ���ڶ����ڵ�͵�һ���ڵ�����
        next.next = head;
        return next;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;

        // ���������Ԫ��
        ListNode cur = head.next.next;
        // ��ʼ��ǰ����Ԫ��
        ListNode pev = head; // ����ǰ����Ԫ�صĵڶ���Ԫ��
        ListNode rs = head.next; // ���

        rs.next = pev;
        pev.next = null; // �ص�

        while (cur != null) {
            if (cur.next != null) {
                // ����Ԫ��
                ListNode a  = cur;
                ListNode b  = cur.next;

                // Ҫ�ȸ�������(Ҫ��Ȼ����Ū��ֵ��ʱ���ɻ�)
                cur = cur.next.next;

                // ִ�н���
                pev.next = b;
                pev.next.next = a;

                // ��������
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