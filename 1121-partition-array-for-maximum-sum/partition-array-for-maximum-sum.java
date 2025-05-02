class Solution {
   public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int len=0,maxi=Integer.MIN_VALUE,maxAns=Integer.MIN_VALUE;
            for(int j=i;j<Math.min(n,i+k);j++){
                len++;
                if(arr[j]>maxi) maxi=arr[j];
                int sum = len*maxi+dp[j+1];

                if(sum>maxAns) maxAns=sum;
            }
            dp[i]=maxAns;
        }

        return dp[0];        
    }
}