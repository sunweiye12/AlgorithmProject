package 参考;

public class Code_04_Manacher {
	
	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

	
	
	//返回最大回文长度
	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);  //返回装饰好的字符数组
		int[] pArr = new int[charArr.length];  //回文半径数组
		int c = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			//index 回文中心
			//2 * index - i ----> i'   pArr[2 * index - i]为i'的回文半径
			//pR > i 加入 i在右边界里面
			//Math.min(pArr[2 * index - i], pR - i) ---> 取i'的回文半径和pR-i中较小的那个
			pArr[i] = pR > i ? Math.min(pArr[2 * c - i], pR - i) : 1;
			
			//如果是情况2和3在上一行中就会得到一个pArr[i]-->
			//对于情况4得到的是pR - i 
			//对于情况1 得到的是1
			//由于情况1和4都需要暴力扩,因此在有初始值的情况下我都扩一下,因为2和3已经有的初始值所以扩一下就失败了
			//这样做的目的是为了不用分情况讨论,减少代码量
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			
			//获取新的回文右边界
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				c = i;
			}
			max = Math.max(max, pArr[i]);//记录全局最大值
		}
		return max - 1;
	}
	
	//为提供的字符添加虚轴,并返回字符数组
	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

}
