package _2baidu;

import org.junit.Test;

public class _02大数相乘 {

	@Test
	public void main() {
		String str = multiply("25","25"); //仅限于两个正数相乘
		System.out.println(str);
	}
	
	public String multiply(String num1, String num2) {
		//将两个int类型转换为char数组
		char[] chars1 = num1.toCharArray();
		char[] chars2 = num2.toCharArray();
		int fuHao1 = 0; 	//0代表没有符号位,1代表符号位为正,2代表符号位为负
		int fuHao2 = 0;	
		int n1[]= new int[chars1.length];  		//没有符号位时数组长度
		int n2[]= new int[chars2.length];
		int n11[]= new int[chars1.length-1];	//有符号位时数组长度
		int n22[]= new int[chars2.length-1];
		//将符号位确定,并将字符数组,转换为响应的int数组
		if (chars1[0] == '-' || chars1[0] == '+') {
			if (chars1[0] == '+') fuHao1 = 1;
			if (chars1[0] == '-') fuHao1 = 2;
			for (int i =1; i < chars1.length; i++){
				n11[i-1] = chars1[i] - '0';
			}
		} else {
			for (int i =0; i < chars1.length; i++){
				n1[i] = chars1[i] - '0';
			}
		}
		
		if (chars2[0] == '-' || chars2[0] == '+') {
			if (chars2[0] == '+') fuHao2 = 1;
			if (chars2[0] == '-') fuHao2 = 2;
			for (int i =1; i < chars2.length; i++){
				n22[i-1] = chars2[i] - '0';
			}
		} else {
			for (int i =0; i < chars2.length; i++){
				n2[i] = chars2[i] - '0';
			}
		}
		
		if(fuHao1 == 0 && fuHao2 == 0){ return partion(n1, n2);}
		if(fuHao1 == 0 && fuHao2 == 1){ return partion(n1, n22);}
		if(fuHao1 == 0 && fuHao2 == 2){ return "-"+partion(n1, n22);}
		if(fuHao1 == 1 && fuHao2 == 0){ return partion(n11, n2);}
		if(fuHao1 == 1 && fuHao2 == 1){ return partion(n11, n22);}
		if(fuHao1 == 1 && fuHao2 == 2){ return "-"+partion(n11, n22);}
		if(fuHao1 == 2 && fuHao2 == 0){ return "-"+partion(n11, n2);}
		if(fuHao1 == 2 && fuHao2 == 1){ return "-"+partion(n11, n22);}
		if(fuHao1 == 2 && fuHao2 == 2){ return partion(n11, n22);}
		return null;
	}

	//传入两个int数组返回他们相乘后的结果
	private String partion(int[] n1, int[] n2) {
		//创建一个用于返回乘机的数组
		//长度为这杨时最后一位的下标为n1.length+n2.length-2(两个数组的下标最大和)
		int result[] = new int[n1.length + n2.length - 1]; 
		//进项相乘运算(模拟的是真实情况下的运算过程,不含进位)
		for (int i = n1.length -1; i >= 0; i--){
			for (int j = n2.length -1; j >= 0; j--) {
				result[i+j] += n1[i] * n2[j];
			}
		}
		
		//进行进位运算(进位时从后往前进位)
		for (int i = result.length - 1; i > 0; i--) {
			result[i-1] += result[i] / 10; //见面进位
			result[i] = result[i] % 10;		//本位得余
		}
		
		//如果最高位是0则直接返回0 (防止出现0000的情况)
		if (result[0] == 0) { 
			return "0";
		}
		
		//返回为string类型,用字符串将数组串起来
		String resultStr = "";
		for (int i = 0; i < result.length; i++) {
			resultStr += result[i];
		}
		return resultStr;
	}
}




