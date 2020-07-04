package _02分类算法._07递归;


/**
* 递归来完成
 * 题目描述：一个公司的上下级关系是一棵多叉树，这个公司要举办晚会，
	  	你作为组织者已经摸清了大家的心理：一个员工的直接上级如果到场，这个员工肯定不会来。
	  	每个员工都有一个活跃度的值，决定谁来你会给这个员工发邀请函，怎么让晚会的气氛最活跃？
	  	返回最大的活跃值。
 * 例如：给定一个矩阵来表述这种关系
		matrix = {
			1,6
			1,5
			1,4
		}
	这个矩阵的含义是：
	matrix[0] = {1,6}，表示0这个员工的直接上级为1,0这个员工自己的活跃度为6
	matrix[1] = {1,5}，表示1这个员工的直接上级为1（他自己是这个公司的最大boss），1这个员工自己的活跃度为5
	matrix[2] = {1,4}，表示2这个员工的直接上级为1，2这个员工自己的活跃度为4
	为了让晚会活跃度最大，应该让1不来，0和2来。最后返回活跃度为10.
思路：本题属于树形动态规划，设当前节点为x，有以下两种可能性：
	可能性1：x来，则结果就是x所有子节点(x1、x2、x3)不来的活跃度 + x的活跃度
	可能性2：x不来，则结果就是Math.max(x的任一子节点x1来的活跃度，x的任一子节点x1不来的活跃度)
			+Math.max(x的任一子节点x2来的活跃度，x的任一子节点x2不来的活跃度)
			+Math.max(x的任一子节点x3来的活跃度，x的任一子节点x3不来的活跃度)
		也就是说，任何一个点的取舍可以看作一种决策，那么状态就是在某个点取的时候或者不取的时候，
		以它为根的子树能有的最大活跃总值。分别可以用f[i,1]和f[i,0]表示第i个人来和不来。
	当i来的时候，dp[i][1] += dp[j][0];//j为i的下属
	当i不来的时候，dp[i][0] +=max(dp[j][1],dp[j][0]);//j为i的下属	

 */
public class _07数组_公司晚会活跃度 {
	
	public static void main(String[] args) {
        int[][] matrix = {{1, 6}, {1, 5}, {1, 4}};
        System.out.println(maxHappy(matrix));
    }

    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }
}

