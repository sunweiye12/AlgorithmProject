package 欢乐颂._08暴力递归_动态规划;
import org.junit.Test;
/*
 * 题目:给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都绝顶聪明。
 * 请返回最后获胜者的分数。
【举例】
arr=[1,2,100,4]。
	开始时玩家A只能拿走1或4。如果玩家A拿走1，则排列变为[2,100,4]，接下来玩家B可以拿走2或4，然后继续轮到玩家A。
	如果开始时玩家A拿走4，则排列变为[1,2,100]，接下来玩家B可以拿走1或100，然后继续轮到玩家A。
	玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B将拿走100。
	所以玩家A会先拿1，让排列变为[2,100,4]，接下来玩家B不管怎么选，100都会被玩家A拿走。玩家A会获胜，分数为101。所以返回101。

arr=[1,100,2]。
	开始时玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜，分数为100。所以返回100
	    
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
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        //以列为外循环
        for (int j = 0; j < arr.length; j++) {
            //初始化f表的对角线
            f[j][j] = arr[j];
            s[j][j] = 0;
            //根据i和j的关系，更新每一列的i 然后从下往上计算i(将这整个dp表填满)
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
	}
}