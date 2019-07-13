package _1bytedance;

import org.junit.Test;

public class _11分割等和子集 {
	
	@Test
	public void main() {

		int[] arr = {1,2,3,4,1};
		System.out.println(canPartition(arr));
	}
	
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        if(sum%2!=0)
            return false;
        return subsetSum(nums,sum>>>1);
    }
    
    public boolean subsetSum(int[] nums, int s) {
        boolean[] dp = new boolean[s + 1]; 
        dp[0] = true;
        for (int n : nums){
            for (int i = s; i >= n; i--){
                dp[i] =dp[i]||dp[i - n]; 
            }
            if(dp[s])
                return true; 
        }
        return dp[s];
    } 
}

