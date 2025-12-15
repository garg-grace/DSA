class Solution {
    public long getDescentPeriods(int[] prices) {

        long res = 1;
        int cnt = 1;

        for(int i=1;i<prices.length;i++) {
            if(prices[i]==prices[i-1]-1) cnt++;
            else cnt=1;
                
            res+=cnt;    
        }
        return res;
    }

    private long fact(int num) {
        if(num<=1) return 1;

        return num*fact(num-1);
    }
}