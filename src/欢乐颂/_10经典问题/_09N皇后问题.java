package 欢乐颂._10经典问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 题目:n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 		(与某一皇后同行或同列可以攻击,与某一皇后位于棋盘的对角线也会形成攻击)
 * 	要求:提供一个n*n的棋盘 ,返回所有不同的 n皇后问题的解决方案。(打印出来)
 * 	例如: 输入4
	输出: 
	// 解法 1
	 [".Q..",  
	  "...Q",
	  "Q...",
	  "..Q."],
	// 解法 2
	 ["..Q.",  
	  "Q...",
	  "...Q",
	  ".Q.."]
	  
 * 思路:利用深度优先遍历来解题(DFS),首先我们可以知道当皇后占据一个位置时,他所处的行和列就不能再放皇后,此处因为每一行找到第一个皇后
 * 		就不在处理此行(来到下一列肯定没有皇后,因此只需关注此列的信息),我们需要用一个集合来标注那些列被占据了(设置一个数组对应的列置为代表占有)
 * 		(此处为可避免越界,利用set集合来实现,每次占用一个列的时候,就见列放入set中,下次只需要判断一下,set中是否存在此列,存在则不能再放)
 * 		另外除了同一列上不能存在一个皇后,棋盘对角线也不能存在两个皇后,因此定义两个集合pie和na对应两条对角线(col列  row行)
 * 		对于i行 j列 的元素如果存在皇后,则pie[i+j]=1代表左对角线 . na[i-j]=1代表右对角线
 * DFS按照每一层进行遍历,遍历到每一层的时候循环他的列,并判断当前位置是否可以放置皇后,如果不可以直接跳过,如果可以,则直接进行下一行
 */
public class _09N皇后问题 {

	@Test
	public void main() {
		// n皇后问题的解决方案
		solveNQueens(8);
	}
	
	public void solveNQueens(int n)	{
		//basecase
		if (n < 1) { return; }
		
		//创建爱你三个集合
		Set<Integer> cols = new HashSet<Integer>();	//用于代表被占用的列
		Set<Integer> pie = new HashSet<Integer>();	//用于代表被占用的反对角线
		Set<Integer> na = new HashSet<Integer>();	//用于代表占用正对角线
		// 创建一个存储皇后位置的集合(每行皇后所在的位置)
		Map<Integer,Integer> reMap =  new HashMap<Integer,Integer>();
		
		// 从第一行开始进行深度有优先遍历
		DFS(0,n,cols,pie,na,reMap);
	}

	// 深度优先遍历
	private void DFS(int row, int n, Set<Integer> cols, Set<Integer> pie,
			Set<Integer> na,Map reMap) {
		
		// 如果到达最后一列则这组数据表示成功
		if (row >= n) {
			System.out.println(reMap);
		}
		
		// 从第一行开始遍历
		for (int col = 0; col < n; col++) {
			// 如果此位置和已有的皇后冲突则将此位置跳过
			if (cols.contains(col) ||  pie.contains(col+row) || na.contains(col-row)) {
				continue;
			}
			// 此皇后占有此位置
			cols.add(col);
			pie.add(col+row);
			na.add(col-row);
			reMap.put(row, col);
			// 递归寻找下一行
			DFS(row+1, n, cols, pie, na,reMap);
			
			// 恢复现场
			reMap.remove(row);
			cols.remove(col);
			pie.remove(col+row);
			na.remove(col-row);
		}
		
	}
}
