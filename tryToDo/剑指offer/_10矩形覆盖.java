package 剑指offer;
/*
 * 题目:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 	        请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 思路:有题意可知 n=0 0种
 * 			  n=1 1种
 * 			  n=2 2种
 * 			  n=3 3种
 *            n=4 5中	
 */
public class _10矩形覆盖 {

	 public int RectCover(int target) {
		 //basecase
		 if (target == 0) return 0;
		 if (target == 1) return 1;
		 if (target == 2) return 2;
		 return RectCover(target-1) + RectCover(target-2);
	 }
}
