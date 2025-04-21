class Solution {
    private int f(int ind,int trans,int n,int[] prices,int[][] dp){
        if(ind==n || trans==4) return 0;
        if(dp[ind][trans]!=-1) return dp[ind][trans];

        if(trans%2==0){
            return dp[ind][trans]=Math.max(-prices[ind]+f(ind+1,trans+1,n,prices,dp),
                                        f(ind+1,trans,n,prices,dp));
        }

        return dp[ind][trans]=Math.max(prices[ind]+f(ind+1,trans+1,n,prices,dp),
                                    f(ind+1,trans,n,prices,dp));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return f(0,0,n,prices,dp);
    }
}