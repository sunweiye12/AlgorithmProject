package _03examination._1bytedance;

import java.util.Scanner;

/*
 *题目: 二叉树的节点按照从上到下，从左到右，从1开始编号，其中空着的节点用“#”表示。输出树的左视图，如：
		输入：1 2 3 # 4 5 6 # # # # 7 8
		输出：1 2 4 7
 * 思路:左视图就是:打印每一层的第一个节点
 */
public class _14二叉树的左视图_1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i= 0;  //当前多少层
        int j = 0; //当前层的第几个节点
        boolean flag = true; //是否为当层的第一个节点

        while(in.hasNext()) {
            i = i+1;
            j = 1;
            flag = true; //默认是第一个节点
            //执行第i层的遍历
            while(j <= Math.pow(2,i-1)) { //pow(2,i-1)第i层的节点个数
                if(!in.hasNext()){ //没有元素了
                	return;  	//如果此层获取到了末尾,则直接结束
                } else{		//有节点的话判断是不是第一个节点
                	String str = in.next(); //获取节点
                	if(flag == true && !str.equals("#")){ //如果是第一个非空节点则输出
                		System.out.print(str + " ");
                		flag = false;
                	}
                	j++;
                }
            }
        }
    }
}
