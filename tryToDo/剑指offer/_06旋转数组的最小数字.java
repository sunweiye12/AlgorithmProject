package 剑指offer;

import org.junit.Test;

/*
 * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
 * 		输入一个非减排序的数组的一个旋转，
 * 		输出旋转数组的最小元素。 
 * 		例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 		 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路1:由于原数组是非减排序的数组,则可以说明下一个自己的下一个位置一定大于等于本身  例如{1,2,3,4,5}
 * 		则旋转后的数组则会是先递增(或相等),然后知道遇到下雨个元素比自己还小,则说明下一个元素就是原数组的头元素,他最小     例如{3,4,5,1,2}
 * 		如果遍历完所有,都没有找到,说明,可能没有交换,第一个为最小的元素   O(n)
 * 思路2:设置一盒全局最小值遍历数组,返回最小值   O(n)
 * 优化思路3:采用二分法解答这个问题，low = 0,high = length-1,mid = low + (high - low)/2
		需要考虑三种情况：
		(1)array[mid] > array[high]:此时最小数字一定在mid的右边。low = mid + 1
		(2)array[mid] == array[high]:出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
			还是右边,这时只好一个一个试 :high = high - 1
		(3)array[mid] < array[high]:此时最小数字一定就是array[mid]或者在mid的左边。因为右边必然都是递增的。
			故:high = mid
 */
public class _06旋转数组的最小数字 {

	@Test
	public void main() {

	}
	
	
	public int minNumberInRotateArray(int [] array) {
		//basecase
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		for (int i = 0; i < array.length-1; i++) {
			if (array[i]>array[i+1]) { //如果下一个元素比自己小则说明,下一个元素就是原数组的第一个元素,将其返回
				return array[i+1];
			}
		}
		return array[0];	//如果遍历完一遍都没有找出,则说明,最小的元素为第一个元素
    }
	
	public int minNumberInRotateArray1(int [] array) {
		//basecase
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		for (int i = array.length-1; i > 0; i--) {
			if (array[i] > array[0]) { 		//从最后面的元素网前找.当找到第一个比array[0]大的元素时,停止输出下一个
				return array[i+1];
			}
		}
		return array[0];	//如果遍历完一遍都没有找出,则说明,最小的元素为第一个元素
    }
	
	public int minNumberInRotateArray3(int [] array) {
        int low = 0 ; int high = array.length - 1;   
        while(low < high){
            int mid = low + (high - low) / 2;        
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }   
        }
        return array[low];
    }
	
	
}
