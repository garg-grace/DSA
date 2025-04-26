class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n=nums.size();
        vector<int> dp(n,1);

        int maxi=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                }
                if(dp[i]>maxi) maxi=dp[i];
            }
        }
        return maxi;
    }
};