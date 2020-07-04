package _03examination._1bytedance;

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
	思路:虽然地精有三种商品，但其实我们只需考虑血瓶和魔法药，因为无敌药水=血瓶+魔法药。先买尽量多的血瓶，若有剩余则用血瓶+50换购魔法药。
 */
public class _13死亡骑士的难题 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        for(int i = 0;i < n;i++){
//            int num = Integer.parseInt(in.nextLine());
//            partion(num);
//        }
            partion1(500);
    }
    
    private static void partion1(int num) {
    	int xueping = 150;
    	int mofa = 200;
    	int wudi = 350;
		int al = 0;//购买的血瓶数量
		int ex = 0; //剩余数量钱数
		
		al = num / xueping; //血瓶的数量
		ex = num % xueping; //卖完血瓶剩余的钱数	
		while(ex >= 50 && al >= 1){
			ex -= 50;
			al--;
		}
		System.out.println(ex);
	}
}
