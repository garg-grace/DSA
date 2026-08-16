class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxi = 0;
        int[] rge = new int[n];
        rge[n-1]=0;

        for(int i=n-2; i>=0; i--) {
            rge[i] = Math.max(rge[i+1],prices[i+1]);

            maxi = Math.max(maxi,rge[i]-prices[i]);
        }
        return maxi;
        
    }
}