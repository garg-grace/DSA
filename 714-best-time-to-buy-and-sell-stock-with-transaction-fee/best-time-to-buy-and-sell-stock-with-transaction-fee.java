class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] after = new int[2];
        int[] curr = new int[2];

        for(int i=n-1;i>=0;i--){
            //buy
            curr[1]=Math.max(-prices[i]-fee+after[0],after[1]);

            //sell
            curr[0]=Math.max(prices[i]+after[1],after[0]);

            after=curr;
        }

        
        return after[1];        
    }
}