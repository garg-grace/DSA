class Solution {
    private int f(int i,int n,int k,int[] arr,int[] dp){
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];

        int len=0,maxi=Integer.MIN_VALUE,maxAns=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(n,i+k);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum = len*maxi+f(j+1,n,k,arr,dp);

            maxAns=Math.max(maxAns,sum);
        }
        return dp[i]=maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return f(0,n,k,arr,dp);        
    }
}