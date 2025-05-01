class Solution {
    private int f(int i,int j,List<Integer> list,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int maxi=0;
        for(int ind=i;ind<=j;ind++){
            int ans=list.get(i-1)*list.get(ind)*list.get(j+1)+f(i,ind-1,list,dp)+f(ind+1,j,list,dp);

            if(ans>maxi) maxi=ans;
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num:nums) list.add(num);
        list.add(1);
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return f(1,n,list,dp);        
    }
}