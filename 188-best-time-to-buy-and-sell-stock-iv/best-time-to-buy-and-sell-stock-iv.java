class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] after = new int[k*2+1];
        int[] curr = new int[k*2+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int trans=k*2-1;trans>=0;trans--){
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