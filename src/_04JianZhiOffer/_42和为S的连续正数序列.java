package _04JianZhiOffer;
import java.util.ArrayList;
import org.junit.Test;

/*
 * 题目:小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 	但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 	他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 	现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * (输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序)
 * 
 * 思路:(直观暴力解)由于连续的和为sum的整数,且最少有两个数.
 * 		则可以从1开始判断,依次遍看看能不能组成sum,能组成就添加到里面list中
 * 			  2开头的连续数能不能组成sum,能组成就添加到里面list中
 * 			 直到sum/2+1时
 */
public class _42和为S的连续正数序列 {

	@Test
	public void main() {
	}
	
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (sum <= 1) {
			return list;
		}
		for (int i = 1; i <= sum/2; i++) { //判断以i开头的连续整数能否存在和为sum
			int j = i;
			int temSum = 0;
			while(temSum <= sum){
				temSum += j;
				j++;
				if (temSum == sum) {
					partionAdd(list,i,j-1); //将i到j作为链表添加到list中
				} 
			}
		}
		return list;
    }

	private void partionAdd(ArrayList<ArrayList<Integer>> list, int i, int j) {
		ArrayList<Integer> temList = new ArrayList<Integer>();
		for(int p = i;p <= j;p++){
			temList.add(p);
		}
		list.add(temList);
	}
}
