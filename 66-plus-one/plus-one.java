class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        int n = digits.length;
        digits[n-1]++;

        for(int i=n-1;i>=0;i--) {
            digits[i]=digits[i]+carry;
            carry=digits[i]/10;
            digits[i]%=10;
        }

        if(carry == 0) return digits;

        int[] res = new int[n+1];
        res[0] = carry;

        for(int i=1;i<=n;i++) {
            res[i]=digits[i-1];
        }
        return res;
    }
}