class Solution {
    public boolean checkDivisibility(int n) {
        return n % (helper(n)) == 0;
    }

    private int helper(int n) {
        int sum = 0;
        int product = 1;
        while(n>0) {
            sum+=(n%10);
            product*=(n%10);
            n/=10;
        }
        return sum+product;
    }
}