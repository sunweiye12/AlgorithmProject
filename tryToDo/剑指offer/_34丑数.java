package 剑指offer;

import org.junit.Test;

/*
 * 题目:把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 		例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 		习惯上我们把1当做是第一个丑数。
 * 		求按从小到大的顺序的第N个丑数。
 * 
 * 思路1(暴力解):所谓的丑数是只能够被2 3 5作为因子的数,所以对于一个丑数不断除以2,不断除以3,不断除以5以后一定为1,
 * 		可以通过这一点来判断此数是不是丑数,可以依次判断某一个数是不是丑数.
 */
public class _34丑数 {
	
	@Test
	public void main() {
		int num = GetUglyNumber_Solution(5); //获取第3个丑数
		System.out.println(num);
	}
	
	
	//暴力解
	public int GetUglyNumber_Solution(int size) {
		if (size < 0) {
			throw new RuntimeException("输入有误");
		}
		if(size == 1){
			return 1;
		}
		int index = 2; 	//第二个丑数开始算
		int num = 2;	//从2开始判断
		while (index != size) {
			if (isChoushu(num)) {
				index++; 
			}
			num++;
		}
        return num;
    }
	
	public boolean isChoushu(int num){
		//只要能整除就进行除法运算
		while(num % 2 == 0) num = num/2;
		while(num % 3 == 0) num = num/3;
		while(num % 5 == 0) num = num/5;
		//如果最后为1,说明是丑数
		return num == 1;
	}
}
