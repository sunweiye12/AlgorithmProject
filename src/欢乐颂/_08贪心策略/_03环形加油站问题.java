package 欢乐颂._08贪心策略;

import org.junit.Test;

/*
 * 题目:已知每个加油站能加的汽油gas[i]，还有第i个加油站到i+1个站点需要花费cost[i]的汽油。 
 * 		假设初始油箱为空，且油箱容量无限，求从哪个站点开始，可以绕一圈。不存在返回-1
 * 
 * 思路:首先想想朴素的算法，对于每个点，如果gas[i] – cost[i] >=0，那么以该点x为起点，向后判断。
 * 路途中若出现油箱为负，说明该起点不对。 起点x +1重复过程。。。
这样显然复杂度为o(n^2)，如何做到更好呢？

上面的过程在起点错误的时候直接进行了+1，就是初始起点的下一个。 
就是说，假如abcdefg 这么多个加油站，a为一开始的站点，遍历到d发现不行了。接着从b开始。
然而这没有必要。 因为在过程中，有：
	gas[a] – cost[a] >=0 （这是枚举的条件）
	gas[a] – cost[a] + gas[b] – cost[b] >=0
	gas[a] – cost[a] + gas[b] – cost[b]  + gas[c] – cost[c] >=0
	gas[a] – cost[a] + gas[b] – cost[b]  + gas[c] – cost[c]  + gas[d] – cost[d] < 0
	在d之前的每一步都是不小于0的。然而他们的累加过不了d这个站点，也就是说，abc都不会是解。
	（比0大的数加上去都过不了了何况不加）而d也不会是解，因为必然有gas[d] – cost[d] < 0
	因此接下来从e开始最好。
 */
public class _03环形加油站问题 {
	
	@Test
	public void main() {
		int[] gas =  {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int i = canCompleteCircuit(gas, cost); //正确4  也就是下标为3的加油站
		System.out.println(i);
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//basecase
        if(gas == null||gas.length == 0){
            return -1;
        }
        int start = 0; //开始的位置
        int remain = 0; //每次剩余的油量
        int total = 0;  //从头开始总的油量减去总的消耗
        for(int i = 0; i < gas.length; ++i){
        	total += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            if(remain < 0){
                remain = 0;
                start = i + 1; //从下一个站点开始
            }
        }
        return total < 0 ? -1 : start;
    }
}
