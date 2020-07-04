package _00工具箱类;

public class _04一维数组随机生成器 {

	
	public static void main(String[] args) {
		int[] arr = generateRandomArray(5,9);
		myPrint(arr);
	}
	
	//打印数组的方法
	private static void myPrint(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	//生成长度随机的数组长度处于[0 , size]中每个元素的值为 [-value , value]
	public static int[] generateRandomArray(int size , int value){
		//生成长度随机的数组 长度处于[0 , size]
		int[] arr = new int[(int)((size + 1) * Math.random())];
//		int[] arr = new int[9];//指定长度
		
		for(int i =0;i < arr.length; i++){
			arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
		}
		return arr;
	}
	
}
