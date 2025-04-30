class Solution {
    public int minCost(int n, int[] arr) {
        List<Integer> cuts = new ArrayList<>();
        for(int a:arr) cuts.add(a);
        cuts.add(0);
        cuts.add(n);
        Collections.sort(cuts);
        int c = cuts.size();
        int[][] dp = new int[c+2][c+2];
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c-2;j++){
                if(i>j) continue;
                int mini=Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int ans=cuts.get(j+1)-cuts.get(i-1)+dp[i][ind-1]+dp[ind+1][j];

                    if(ans<mini) mini=ans;
                }
                dp[i][j]=mini;
            }
        }

        return dp[1][c-2];   
    }
}