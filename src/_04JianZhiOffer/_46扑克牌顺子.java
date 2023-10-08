package _04JianZhiOffer;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:一副牌一共54张,这有一副56张的扑克牌(多了一对大小王),随机从里面抽五张牌,判断是不是顺子 (大小王认为是0)--其中大小王可以代表任意牌
 * 		相当于0-13每个点数都有4个
 * 
 * 思路:抽好了5张牌.可以这样判断其是否为顺子
 * 		1.如果这里面有点数相等,则返回false
 *		2.如果都不相等,则找到5个数中最大的数和最小的数,如果差值为5则返回true.否则返回false
 */		
public class _46扑克牌顺子 {

	@Test
	public void main() {
		int[] num = {0,3,2,6,4};
		boolean b = isContinuous(num);
		System.out.println(b);
	}
	
	public boolean isContinuous(int [] num) {
		//basecase
		if (num==null||num.length < 5) {
			return false;
		}
		//创建用于去重的set集合
		Set<Integer> set = new HashSet<Integer>();
		int max = Integer.MIN_VALUE;//全局最大值
		int min = Integer.MAX_VALUE;//全局最大值
		
		for (int i = 0; i < num.length; i++) {
			if (num[i] == 0) { //如果是0的话就跳过,最后根据set中的个数可以判断0的个数
				continue;
			}
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
			if (!set.contains(num[i])) { //如果不包含就放进来
				set.add(num[i]); 
			} else{						//如果包含则说明重复,则返回false
				return false;
			}
		}
		int lingSize = 5 - set.size(); //包含0的个数
		if (lingSize == 0) {
			return max-min==4;
		} else if(lingSize == 1){
			return max-min==4 || max-min==3;
		} else if (lingSize == 2){
			return max-min==4 || max-min==3|| max-min==2;
		} else if (lingSize == 3){
			return max-min==4 || max-min==3|| max-min==2 || max-min==2;
		} else if (lingSize == 4){
			return true;
		}
		return true;
    }
}
