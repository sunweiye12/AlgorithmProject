package _03examination._1bytedance;
import java.util.LinkedList;
import java.util.Scanner;
/*
 * 题目:我手中有一堆扑克牌， 但是观众不知道它的顺序。
	1、第一步， 我从牌顶拿出一张牌， 放到桌子上。
	2、第二步， 我从牌顶再拿一张牌， 放在手上牌的底部。
	3、第三步， 重复第一步、第二步的操作， 直到我手中所有的牌都放到了桌子上。
	最后， 观众可以看到桌子上牌的顺序是：(牌底部）1,2,3,4,5,6,7,8,9,10,11,12,13(牌顶部）
	请问， 我刚开始拿在手里的牌的顺序是什么？
 * 
 */

public class _09摊牌找顺序 {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] str = line.split(",");
        int[] nums = new int[str.length];
        for(int i=0;i<str.length;i++)
            nums[i]=Integer.parseInt(str[i]);
        sort(nums);
    }
 
    public static void sort2(int[] pokers) {
        // 正向操作过程, 将手中的牌放到桌子上
        // 第一步先创建一个链表
        LinkedList<Integer> pokerList = new LinkedList<Integer>();
        for (int poker : pokers) {
            pokerList.add(poker);
        }
        //声明一个新的容器，在这里可以理解成桌子
        LinkedList<Integer> newPokers2 = new LinkedList<Integer>();
        for (int i = 0; i < pokers.length; i++) {
            //将手牌中的第一张放在桌子上
            newPokers2.add(pokerList.pollFirst());
            //假如这是最后一次循环手牌已经没有了就不需要进入这个判断了
            if (pokerList.size() > 0) {
                //将第一张放在牌堆的最后
                pokerList.addLast(pokerList.pollFirst());
            }
        }
        //打印到控制台，
		System.out.println(newPokers2);
    }
 
    /**
     * 这里的操作是从桌子把牌拿回到手上
     * 从桌子 到 手上 int[] t = {13,12,11,10,9,8,7,6,5,4,3,2,1};
     * 返回 {1,12,2,8,3,11,4,9,5,13,6,10,7}
     *
     * @param pokers
     */
    public static void sort(int[] pokers) {
        // 反向操作, 将桌子上的牌变到手上
        // 创建一个链表理解为桌子
        LinkedList<Integer> pokerList = new LinkedList<Integer>();
        for (int poker : pokers) {
            pokerList.add(poker);
        }
        //声明一个目标容器，理解成手
        LinkedList<Integer> newPokers2 = new LinkedList<Integer>();
        for (Integer aPoker : pokerList) {
            //判断手上的牌是否大于1张
            if (newPokers2.size() > 1) {
                //如果大于一张，则把手牌的最后一张放在最上面
                newPokers2.addFirst(newPokers2.pollLast());
            }
            //从桌子上拿一张牌放在手上
            newPokers2.addFirst(aPoker);
        }
        //打印到控制台，
        System.out.println(newPokers2);
    }
 
}

