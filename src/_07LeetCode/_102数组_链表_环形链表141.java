package _07LeetCode;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/
 * ��ϸ��:��ֻ��һ���ڵ�,����Ϊnull��ʱ��,��Ϊ���ֻ�����û�л�?
 *
 * ˼·1: ͨ��set�ṹ��ʵ��,��ͷ��ʼ����,��ÿһ��Ԫ���ж�set�Ƿ���ڲ��ӵ�set,
 *  ���set��ʼ��û���ظ�������˵��û�л�.������л�. ʱ��O(n) �ռ�O(n)
 *
 * ˼·2: ͨ������ָ����ʵ��,����ָ�뿪ʼ��ָ��head,��ָ��һ����һ��,��ָ��һ��������,
 * ����ڷ����յ�֮ǰ����������,��˵���ֻ�.
 *
 */

public class _102����_����_��������141 {

    @Test
    public void main() {
        System.out.println("��ʼ");

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