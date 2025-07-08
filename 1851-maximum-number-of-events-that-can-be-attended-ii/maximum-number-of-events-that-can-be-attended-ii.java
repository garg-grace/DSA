class Solution {
    private int solve(int[][] events,int i,int n,int k,int[][] dp){
        if(i>=n || k<=0) return 0;

        if(dp[i][k]!=-1) return dp[i][k];

        int start = events[i][0];
        int end = events[i][1];
        int val = events[i][2];

        int skip = solve(events,i+1,n,k,dp);
        int j = binarySearch(events,end+1,i+1);
        int take = val+solve(events,j,n,k-1,dp);

        return dp[i][k]=Math.max(skip,take);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); 
        int n = events.length;

        int[][] dp = new int[n + 1][k + 1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

        return solve(events,0,n,k,dp);
    }
    private int binarySearch(int[][] events, int lastEnd,int left) {
        int right = events.length - 1;
        int result = events.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] >= lastEnd) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}