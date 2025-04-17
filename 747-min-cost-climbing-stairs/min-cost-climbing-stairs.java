class Solution {
    private int f(int stair,int[] cost,int[] dp){
        if(stair==0) return cost[0];
        if(stair<0) return 0;
        if(dp[stair]!=-1) return dp[stair];

        return dp[stair]=cost[stair]+Math.min(f(stair-1,cost,dp),f(stair-2,cost,dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return Math.min(f(n-1,cost,dp),f(n-2,cost,dp));
        
    }
}