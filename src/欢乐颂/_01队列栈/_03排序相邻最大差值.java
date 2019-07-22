package 欢乐颂._01队列栈;

import org.junit.Test;

/**
题目:
 	给定一个数组，求如果排序之后，相邻两数的最大差值.
要求:时间复杂度O(N)，且要求不能用非基于比较的排序。(不能使用排序算法)
思路:如果给定的数组长度为N,则创建N+1个桶,找到这N个数的最小值和最大值分别放到第一个和最后一个桶中
	然后将最小值和最大值做差分成N+1段,每段分别对应一个桶,然后遍历将每个元素分别放到对应的桶中
	则其中必然会有一个桶是空的(----),这就可以保证,在一个桶内不会最大的相邻两个数,然后遍历每个桶
	让每个桶的最大值与右面非空桶的最小值做差,最大的差就是返回的在大相邻值
(每个桶值存三个变量,是否有值,最大值,最小值)
 * @author Administrator
 */
public class _03排序相邻最大差值 {
	
	@Test
	public  void main() {
		int[] arr = {1 ,2, 6, 9};
		int max = getSortMax(arr);	 
		System.out.println(max);
	}
	

	private int getSortMax(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		
		int N = arr.length;  //得到数组的长度
		
		//创建N+1个桶  (三个长度为N+1的数组)---> 最大下标为N
		boolean[] hasNum = new boolean[N+1]; //初始化都为false
		int[] buketMax = new int[N+1];
		int[] buketMin = new int[N+1];
		
		//得到数组中的最大值与最小值
		int max = Integer.MIN_VALUE;
		for (int i=0 ;i < arr.length;i++) {
			max = arr[i] > max? arr[i] : max;
		}
		int min = Integer.MAX_VALUE;
		for (int i=0 ;i < arr.length;i++) {
			min = arr[i] < min? arr[i] : min;
		}
		
		//如果最大值和最小值相等说明只有一个数,故返回0
		if (min == max) {
			return 0;
		}
		
		//将最大值和最小值分别放入第一个桶和最后一个桶
		hasNum[0] = true;
		hasNum[N] = true;
		buketMax[0] = min; 
		buketMin[0] = min; 
		buketMax[N] = max; 
		buketMin[N] = max; 
		
		
		//遍历通过调用方法将每个元素放入到对应的桶
		for (int i=0 ;i < arr.length;i++) {
			//返回改元素所对应的桶
			int index = getIndex(arr[i],min,max,N);   //有问题
			//将该元素放到特定的桶中
			addBuket(index,arr[i],hasNum,buketMax,buketMin);
		}
		
		//遍历所有的桶让每一个人非空桶的最小值与左侧非空桶的最大值做差,最大的差就是返回答案
		int result=0;
		for(int i=0;i<N+1;i++){
			//第一个桶我只取他的最大值
			if (i==0) {
				max = buketMax[0];
			} else if(hasNum[i]) {	
			//然后我去寻找他的下一个非空的桶,取到他的最小值,与上一个桶的最大值作比较,然后在取到这个桶中的最大值用于下一次比较
				min = buketMin[i];
				result = Math.max( result, (min-max));
				max = buketMax[i];
			} 
		}
		return result;
	}

	//获取每个元素对应的桶下标
	private int getIndex(int num, int min,int max, int N) {
		int part = (int)(max-min)/N; 	//代表每一块的长度
		return (int)((num - min)/part); //返回位于第几块位置
	}

	//将数组中的每一个数放到对应的桶中
	private void addBuket(int index, int cur, boolean[] hasNum, int[] buketMax,
			int[] buketMin) {
		if (!hasNum[index]) {
			hasNum[index] = true;
			buketMax[index] = cur;
			buketMin[index] = cur;
		} else {
			buketMax[index] = Math.max(cur , buketMax[index]);
			buketMin[index] = Math.min(cur , buketMin[index]);
		}
	}
	
}
