class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadNotBuy,aheadBuy,currNotBuy,currBuy;
        aheadNotBuy=aheadBuy=0;
        for(int i=n-1;i>=0;i--){
            currBuy = Math.max(-prices[i]+aheadNotBuy,aheadBuy);
            currNotBuy=Math.max(prices[i]+aheadBuy,aheadNotBuy);

            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }

        return aheadBuy;
    }
}