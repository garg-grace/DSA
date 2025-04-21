class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] after = new int[5];
        int[] curr = new int[5];

        for(int ind=n-1;ind>=0;ind--){
            for(int trans=3;trans>=0;trans--){
                if(trans%2==0){
                    curr[trans]=Math.max(-prices[ind]+after[trans+1],after[trans]);
                }else{
                    curr[trans]=Math.max(prices[ind]+after[trans+1],after[trans]);
                }
            }
            after=curr;
        }
        
        return after[0];
    }
}