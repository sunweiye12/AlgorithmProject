package _07LeetCode;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * �ж��������Ƿ��л�,���ػ���ʼ��λ��
 * ��ϸ��:��ֻ��һ���ڵ�,����Ϊnull��ʱ��,��Ϊ���ֻ�����û�л�?
 *
 * ˼·1: ͨ��set�ṹ��ʵ��,��ͷ��ʼ����,��ÿһ��Ԫ���ж�set�Ƿ���ڲ��ӵ�set,
 *  ���set��ʼ��û���ظ�������˵��û�л�.������л�.,�����ظ�ʱ�Ľڵ� ʱ��O(n) �ռ�O(n)
 *
 * ˼·2: ����һ����ѧ���⣬ �������¼��裺���軷����ڽڵ�ǰ��a���ڵ㣬����b���ڵ㣬����ָ���ڻ���ڽڵ��ĵ�c���ڵ㴦����
 * �����ʱ��ָ������n��������n=a+ib+c������iΪ���� ���ʱ��ָ������2n����
 * ����n=2a+2ib+2c=a+jb+c������jΪ���� ���ݵ�ʽ���Եó�a+c = (j-2i)b = kb������k=j-2i��ҲΪ��������֪j>2i����������Ҫ
 * ��ʱ��ָ��Ϊ���뻷��ڽڵ�c������ֻҪ����a�����ܹ����뻷��ڽڵ�kb���������ﻷ��ڽڵ㣬֤��
 *
 */

public class _104����_����_142 {

    @Test
    public void main() {
        System.out.println("��ʼ");

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode ret = detectCycle(listNode1);
        System.out.println(ret);

    }

    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;

    }

    public ListNode detectCycle1(ListNode head) {


        ListNode a = head;
        ListNode b = head;
        //ѭ�����ж��߼����жϿ�ľ�����
        //�������һ��������Ҳ�ж�һ��b.next
        while(b != null && b.next != null){
            a = a.next;         //��ָ��
            b = b.next.next;    //��ָ��
            //��ѧ֤�����ѿ���ָ���һ������ʱ�����µ�״̬
            //�����״̬��ʼ������������һ����ָ��
            //һ����head�ߣ�һ������������
            //������ָ���������ĵط����ǻ������
            if(a == b){
                ListNode x = head;
                ListNode y = a;     //a����b����
                while(x != y){
                    x = x.next;
                    y = y.next;
                }
                return x;
            }
        }
        return null;

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