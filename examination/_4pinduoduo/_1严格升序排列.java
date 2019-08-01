package _4pinduoduo;
/*
 * 题意:有两个数组.其中arr1是微严格升序排列(其中只有一个元素,其它的都是严格升序排列)
 * 		需要找出个个元素,然后在arr2中找出一个最大的元素替代它,如果找不到则输出 NO
 * 		如果能找到则是输出 arr1
 */
public class _1严格升序排列 {

	public static void main(String[] args) {
		int[] arr1 = {1,3,7,9,8};
		int[] arr2 = {2,1,5,8,9,11};
		partion(arr1,arr2);
	}

	///找到arr1中对应的元素,和其前
	private static void partion(int[] arr1, int[] arr2) {
		if(arr1 == null || arr2 == null || arr1.length <= 1){
			System.out.print("NO");
			return;
		}
		int index = 0;
		while (index < arr1.length-1 && arr1[index] < arr1[index+1]) {
			index++;
		}
		//得到下表为i
		if (index == arr1.length-1) {
			System.out.print("NO");
			return;
		}
		if (index == 0) {
			int tem = Integer.MIN_VALUE;//原来位置上的值
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] < arr1[1]) {
					tem = Math.max(tem, arr2[i]);
				}
			}
			if (tem == Integer.MIN_VALUE) {
				System.out.print("NO");
				return;
			} else{
				arr1[0] = tem;
				for (int i : arr1) {
					System.out.print(i+" ");
				}
				return;
			}
		} else if (index == arr1.length-2) {
			int tem = Integer.MIN_VALUE;//原来位置上的值
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] > arr1[arr1.length-2]) {
					tem = Math.max(tem, arr2[i]);
				}
			}
			if (tem == Integer.MIN_VALUE) {
				System.out.print("NO");
				return;
			} else{
				arr1[arr1.length-1] = tem;
				for (int i : arr1) {
					System.out.print(i+" ");
				}
				return;
			}
		} else{
			int tem = Integer.MIN_VALUE;//原来位置上的值
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] > arr1[index] && arr2[i] < arr1[index+2]) {
					tem = Math.max(tem, arr2[i]);
				}
			}
			if (tem == Integer.MIN_VALUE) {
				System.out.print("NO");
				return;
			} else{
				arr1[index+1] = tem;
				for (int i : arr1) {
					System.out.print(i+" ");
				}
				return;
			}
		}
	}
}
