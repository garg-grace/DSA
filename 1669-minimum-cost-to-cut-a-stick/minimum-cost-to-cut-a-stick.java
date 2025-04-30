class Solution {
    private int f(int i,int j,List<Integer> cuts,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            int ans = cuts.get(j+1)-cuts.get(i-1)+f(i,ind-1,cuts,dp)+f(ind+1,j,cuts,dp);

            if(ans<mini) mini=ans;
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] arr) {
        List<Integer> cuts = new ArrayList<>();
        for(int a:arr) cuts.add(a);
        cuts.add(0);
        cuts.add(n);
        Collections.sort(cuts);
        int c = cuts.size();
        int[][] dp = new int[c+1][c+1];
        for(int i=0;i<=c;i++) Arrays.fill(dp[i],-1);

        return f(1,c-2,cuts,dp);   
    }
}