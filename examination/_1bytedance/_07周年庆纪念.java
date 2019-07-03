package _1bytedance;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * 题目:公司成立的日期为2012年3月12日,随便给你一个日期,返回公司成立了多少天
 * 
 * 例如:2012 3 13    -->  1天
 *     2019 3 12   -->  2556天
 * 
 */
public class _07周年庆纪念 {

	public static void main(String[] args) {
		
		String date = "2019 3 13"; //输入的日期
		String[] dateStr = date.split(" +");
		int[] dateArr = new int[3];
		dateArr[0] = Integer.parseInt(dateStr[0]);
		dateArr[1] = Integer.parseInt(dateStr[1]);
		dateArr[2] = Integer.parseInt(dateStr[2]);
		int num = parttion(dateArr); //输入当前日期返回成立天数(输入日期超前返回-1)
		System.out.println(num);
	}

	private static int parttion(int[] dateArr) {
		//basecase  将小于的剔除返回-1
		if (dateArr[0] < 2012 || (dateArr[0] == 2012 && dateArr[1] < 3) 
				|| (dateArr[0] == 2012 && dateArr[1] == 3 && dateArr[2] < 12)) {
			return -1;
		} 
		int[] arr = {2012,3,12}; //创建日期
		int[] Mday_notR = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] Mday_R = {31,29,31,30,31,30,31,31,30,31,30,31};
		int count1 = 72; //2012年后的第72天
		int count2  = 0; //本年过了多少天
		for (int i = 0; i < dateArr[1]-1; i++) {
			if (dateArr[0] % 4 == 0) {
				count2 += Mday_R[i];
			} else {
				count2 += Mday_notR[i];
			}
		}
		count2 += dateArr[2];
		//getDay()当前年初距离2012年初多少天
		int count3 = getDay(dateArr[0]) + count2; //count3为距离2012年年初的天数
		return count3 - count1;
	}
	//输入一个年数,返回迎元旦时距离2012年的天数
	private static int getDay(int year) {
		int tem = year - 2012; //年数
		if (tem == 0) {
			return 0;
		}else {
			int i = (int)Math.ceil(tem/4); //为瑞年的个数
			return i * 366 + (tem - i) * 365 + 1;
		}
	}
}
