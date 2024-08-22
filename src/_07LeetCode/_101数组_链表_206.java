package _07LeetCode;
import org.junit.Test;

/**
 * ���ӣ�https://leetcode.cn/problems/reverse-linked-list/description/
 * ��ϸ��: �����в����л�
 *
 * ˼·1:
 * 1. ��������ָ��,�ֱ�ָ����һ��Ԫ��pev,��ǰԪ��cur,��һ��Ԫ��net
 * ��ʼ״̬��1��prvΪ�� 2��curΪhead
 * ��cur��Ϊ�յ�ʱ�������
 *  1)����netָ��Ϊcur.next (��ʱ����)
 *  2)��cur.nextָ��pev.
 *  3)����pev��cur��ָ��
 */

public class _101����_����_206 {

    @Test
    public void main() {
        System.out.println("��ʼ");

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
            // �����м����
            ListNode net = cur.next;
            // ��nextָ��ָ��ǰһ��
            cur.next = pev;

            //����ָ��
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