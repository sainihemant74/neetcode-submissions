class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        int res=helper(nums,dp,0);
        return res;
    }
    int helper(int[] nums, int[] dp, int idx) {
        if(idx >= nums.length ){
            return 0;
        }

        if(dp[idx] !=0){return dp[idx];}

        int take = nums[idx] + helper(nums,dp,idx+2);
        int not  = 0 + helper(nums,dp,idx+1);
        dp[idx] = Math.max(take, not);
        return dp[idx];
    }
}

// recursion + memo
// idx = dp[idx] = maximum amount could be stolen from index till end 
// take = dp[i] + rob(i+2)
// not = 0+ rob(i+1);
// dp[i] = Math.max (take,not);
// base case -> idx >= len -> return 0; 