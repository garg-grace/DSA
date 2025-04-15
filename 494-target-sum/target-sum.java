class Solution {
    private int ways(int[] nums,int target){
        int n = nums.length;
        int[][] dp = new int[n][target+1];

        dp[0][0] = nums[0]==0?2:1;
        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;

        for(int i=1;i<n;i++){
            for(int t=0;t<=target;t++){
                int nonTake = dp[i-1][t];
                int take = 0;

                if(nums[i]<=t) take = dp[i-1][t-nums[i]];

                dp[i][t]=take+nonTake;
            }
        }

        return dp[n-1][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int num:nums) totalSum+=num;

        if(totalSum-target<0 || (totalSum-target)%2!=0) return 0;

        return ways(nums,(totalSum-target)/2);        
    }
}