class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(1+dp[j]>dp[i]){
                        dp[i]=1+dp[j];
                        cnt[i]=cnt[j];
                    }else if(1+dp[j]==dp[i]){
                        cnt[i]+=cnt[j];
                    }
                }
            }
            if(dp[i]>maxi) maxi=dp[i];
        }

        int nos=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi) nos+=cnt[i];
        }
        return nos;
    }
}