package 欢乐颂._10经典算法;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

/*
 * 题目:给定你一个int类型的数组,和一个arm值.返回子数组中所有数和小于等于arm的最长的子数组的长度.
 * 例如:int arr = {7,3,2,1,1,7,7,7}  int arm = 7				
 * 因为和为7的最长子数组为{3,2,1,1},则返回的 4
 * 
 * 暴力解思路:求出所有子数组,分别计算每个子数组的和时是否为arm,然后在保留一个最大长度进行返回
 * 
 * 升级思路:准备过程创建两个数组min_sum[]和min_sun_index[]长度都为arr.length
 * 		sums[i] 代表从第i个位置开始往后所能加出的最小累加和
 * 		ends[i] 代表从第i个位置开始往后所能加出的最小累加和的最后一位的下标(相当最小和的右边界)
 * 		求着两个数组的时候都是从后往前求,O(n)的时间复杂度,如下所示
 * 例如:       arr = {1,-3,4,-5,7,3,-6,9}
 * 	      	 sums = {-3,-4,-1,-5,4,-3,-6,9}
 * 			 ends = {3,3,3,3,6,6,6,7}
 * 
 * 计算过程:当计算从0开始的子数组时,先拿到以0位置元素开头的最小累加和sum1,如果小于aim,在拿出ends[0]+1位置处的最小累加和sum2
 * 		如果sum1+sum2还是小于arm就接着往下找,直到sum1+sum2+..大于arm,记录上以也小于arm时的字符串长度,即以0开头小于等于arm的最长子数组长度
 * 在计算以0开头的时候是(0--T)(T+1)范围在加上(T+1)时发生了大于arm
 * 因此将arr[0]踢出掉,看看只包含(1--T)时能不能将(T+1)加进来,如果能即按照照上面的逻辑继续扩充,记录以1位置开头的最长子数组,如果不能则-->
 * 然后在arr[1]踢出掉,看看(2--T)时能不呢过将(T+1)加进来....依次类推      (保持右边界不回退)
 */
public class _02累加和小于等于指定值的最长子数组长度_3 {
	
	@Test
	public void main() {
		int[] arr = {7,3,2,1,1,7,7,7};
		int arm = 7;
		int len = getMaxLong(arr,arm);
		System.out.println(len);
	}

	//双指针
	private int getMaxLong(int[] arr, int arm) {
		//basecase
		if(arr == null || arr.length == 0 || arm <= 0){
			return 0;
		}
		int[] sums = new int[arr.length]; //最小和数组
		int[] ends = new int[arr.length]; //右边界数组
		//赋初始值
		sums[arr.length - 1] = arr[arr.length-1];
		ends[arr.length - 1] = arr.length - 1;
		
		//依次从后向前生成两个数组的信息
		for (int i = arr.length - 2; i >= 0; i--) {
			if (sums[i + 1] < 0) { //如果后一位小于0说明有利可图,将拓展后面的最小和
				sums[i] = arr[i] + sums[i+1];	//最小和额为当前元素加上后面的最小和
				ends[i] = ends[i+1];			//右边界就是后面最小和的右边界
			} else {			//如果后一位大于等于0,说明无利可图,则不向后扩展,最小和为自己,右边界为自己的下标
				sums[i] = arr[i];
				ends[i] = i;
			}
		}
		
		//右边界初始位置
		int R = 0;
		//初始的窗口元素和
		int sum = 0;
		//子数组初始长度
		int len = 0; 
		for (int start = 0; start < arr.length; start++) {
			while(R < arr.length && sum +sums[R] <= arm){
				sum += sums[R];
				R = ends[R] + 1;
			}
			len = Math.max(len, R - start); //收集当前的长度  (此处R指向的就是最优边界的下一个元素)
			/*重点分析R和start可能存在的相等关系*/
			sum -= R == start? 0 : arr[start] ;//减去头部一个的元素,看一下手否可以向后扩展
			R = Math.max(R, start + 1);		//判断如果减去R所指向的元素时,要自动向后扩展
		}
		return len;
	}
}
