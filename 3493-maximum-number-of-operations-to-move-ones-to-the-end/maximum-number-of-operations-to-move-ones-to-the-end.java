class Solution {
    public int maxOperations(String s) {
        int zeros = 0;
        int ops = 0;
        int n = s.length();

        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i)=='0'){
                if(i==n-1 || s.charAt(i+1)=='1') zeros++;
            }else{
                ops+=zeros;
            }
        }
        return ops;
    }
}