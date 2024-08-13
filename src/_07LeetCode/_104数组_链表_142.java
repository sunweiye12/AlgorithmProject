package _07LeetCode;
import org.junit.Test;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 * 判断链表中是否有环,返回环开始的位置
 * 问细节:当只有一个节点,或者为null的时候,认为是又环还是没有环?
 *
 * 思路1: 通过set结构来实现,从头开始遍历,将每一个元素判断set是否存在并扔到set,
 *  如果set中始终没有重复数据则说明没有环.否则就有环.,返回重复时的节点 时间O(n) 空间O(n)
 *
 * 思路2: 就是一个数学问题， 作出如下假设：假设环的入口节点前有a个节点，环有b个节点，快慢指针在环入口节点后的第c个节点处相遇
 * 假设此时慢指针走了n步，则有n=a+ib+c，这里i为整数 则此时快指针走了2n步，
 * 则有n=2a+2ib+2c=a+jb+c，这里j为整数 根据等式可以得出a+c = (j-2i)b = kb，这里k=j-2i，也为整数，易知j>2i，不过不重要
 * 此时慢指针为距离环入口节点c步处，只要再走a步就能够距离环入口节点kb步，即到达环入口节点，证毕
 *
 */

public class _104数组_链表_142 {

    @Test
    public void main() {
        System.out.println("开始");

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
        //循环的判断逻辑是判断快的就行了
        //快的两步一跳，所以也判断一下b.next
        while(b != null && b.next != null){
            a = a.next;         //慢指针
            b = b.next.next;    //快指针
            //数学证明，把快慢指针第一次相遇时当成新的状态
            //从这个状态开始再来两个速率一样的指针
            //一个从head走，一个从相遇点走
            //这两个指针再相遇的地方就是环的入口
            if(a == b){
                ListNode x = head;
                ListNode y = a;     //a或者b都行
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