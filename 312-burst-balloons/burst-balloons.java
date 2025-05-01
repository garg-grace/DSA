class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int num:nums) list.add(num);
        list.add(1);
        int[][] dp = new int[n+2][n+2];

        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int maxi=0;
                for(int ind=i;ind<=j;ind++){
                    int cost = list.get(i-1)*list.get(ind)*list.get(j+1)+dp[i][ind-1]+dp[ind+1][j];

                    if(maxi<cost) maxi=cost;
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][n];        
    }
}