class Solution {
    public int totalMoney(int n) {
        int weeks = n/7;
        int extraDays = n%7;
        int totalMoney = 0;

        for(int i=1;i<=weeks;i++){
            totalMoney += 7*(i+3);
        }
        
        return totalMoney + extraDays*(weeks+1+weeks+extraDays)/2;
    }
}