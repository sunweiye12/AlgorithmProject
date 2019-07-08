package _1bytedance;
import java.util.*;
/*
 * 题目:不死族的巫妖王一般会在月末会给死亡骑士发工资,而死亡骑士拿到工资(总是为一张N元的钞票，记住,只有一张钞票),
 * 为了防止下月自己在战斗中频繁的死掉,他会给自己买一些道具,于是他来到了地精商店前死亡骑士:"我要买道具!"
	地精商人:"我们这里有三种道具,血瓶150块一个,魔法药200块一个,无敌药水350块一个."
	死亡骑士:"好的,给我一个血瓶."说完他掏出那张N元的大钞递给地精商人.
	地精商人:"我忘了提醒你了,我们这里没有找客人钱的习惯的,多的钱我们都当小费收了的,嘿嘿."死亡骑士:"......"
	死亡骑士想,与其把钱当小费送个他还不如自己多买一点道具,反正以后都要买的,早点买了放在家里也好,但是要尽量少让他赚小费.
	现在死亡骑士遇到了难题，希望你能帮他计算一下,最少他要给地精商人多少小费。
	
	输入:2                输出       40
		340			0
		900
 */
public class _13死亡骑士的难题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0;i < n;i++){
            int num = Integer.parseInt(in.nextLine());
            partion(num);
        }
    }
    
    public static void partion(int num){
        if(num<150){
            System.out.println(num);
            return;
        }
        if(num%150 == 0 || num%200 == 0 || num%350 == 0){
            System.out.println(0);
            return;        
        }
        int min = num%350;
        min = Math.min(min,num%200);
        min = Math.min(min,num%150);
        System.out.println(min);
    }
}
