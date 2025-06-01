class Solution {
    public long distributeCandies(int n, int limit) {
        long minCh1 = Math.max(0,n-2*limit);
        long maxCh1 = Math.min(n,limit);
        long ways = 0;
        for(long i=minCh1;i<=maxCh1;i++){
            long N = n-i;
            long minCh2 = Math.max(0,N-limit);
            long maxCh2 = Math.min(N,limit);
            ways += (maxCh2-minCh2+1);
        }
        return ways;        
    }
}