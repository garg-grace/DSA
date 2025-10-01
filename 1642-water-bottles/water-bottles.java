class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;

        while(numBottles>=numExchange){
            int ex = numBottles/numExchange;
            res += (ex*numExchange);
            numBottles = (numBottles%numExchange)+ex;
        }
        
        return res+numBottles;
    }
}