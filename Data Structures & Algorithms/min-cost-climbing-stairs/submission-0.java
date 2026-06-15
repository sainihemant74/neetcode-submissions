class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //int min=0;
        int dp[]= new int[cost.length];
        Arrays.fill(dp,-1);
        int a=helper(0,cost,dp);
        int b=helper(1,cost,dp);
        return Math.min(a,b);
    }
    int helper(int idx,int cost[],int dp[]){
        int size = cost.length;
        if(idx>=size){
            return 0;
        }
        if (dp[idx] != -1) return dp[idx];

           int take1step   = helper(idx+1,cost,dp);
           int take2step   = helper(idx+2,cost,dp);
           //int notTake= helper(idx+1,cost,dp,dp[i]) ;
           //dp[idx]=     Math.min(take1step,take2step);
            dp[idx] = cost[idx] + Math.min(take1step, take2step);
        //}
     return dp[idx];  
    }
}