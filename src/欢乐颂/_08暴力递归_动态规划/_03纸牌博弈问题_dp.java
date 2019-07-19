package 欢乐颂._08暴力递归_动态规划;
import org.junit.Test;
/*
 * 题目:给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。
 * 请返回最后获胜者的分数。
动态规划:有2个不同的递归函数，需要两张表，每一张表需要2个参数：i，j
	1.i肯定不会大于j（下半区域直接不用填），先看目标位置（打星星的地方），然后填上不依赖的值，从递归中看出 i==j的时候，可以直接得出结果，
		在表中填写上对应的值
	2.查看普遍位置是怎么依赖的
		f(i,j)与s的s(i+1,j)和s(i,j-1)有关
		s(i,j)与f的f(i+1,j)和f(i,j-1)有关
 */
public class _03纸牌博弈问题_dp {
	@Test
	public void main(){
		int[] arr = {1,2,100,4};
		int print2= getWinPoint_dp(arr);
		System.out.println(print2);
	}
	//动态规划解法
	private int getWinPoint_dp(int[] arr) {
		if (arr == null || arr.length == 0) {
            return 0;
        }
		//frist[x][y] 是指从下表为x到下标为y,先拿的人,可以得到的最大值
        int[][] frist = new int[arr.length][arr.length];
        int[][] second = new int[arr.length][arr.length];
        //初始化f表的对角线(当只有一张钱的时候,肯定先拿的人)
        for (int i = 0; i < second.length; i++) {
        	frist[i][i] = arr[i];
        	//second[j][j] = 0; 与初始化相符
		}
        for (int j = 0; j < arr.length; j++) { //代表着右边界
            //根据i和j的关系，更新每一列的i然后从下往上计算i(将这整个dp表填满)
            for (int i = j - 1; i >= 0; i--) { //左边界从右边界向做扩展
                frist[i][j] = Math.max(arr[i] + second[i + 1][j], arr[j] + second[i][j - 1]);
                second[i][j] = Math.min(frist[i + 1][j], frist[i][j - 1]);
            }
        }
        return Math.max(frist[0][arr.length - 1], second[0][arr.length - 1]);
	}
}