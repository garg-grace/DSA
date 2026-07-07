class Solution {
    public long sumAndMultiply(int n) {
        String str = Integer.toString(Math.abs(n));
        String reversedStr = new StringBuilder(str).reverse().toString();
        n = Integer.parseInt(reversedStr);
        long sum = 0;
        long x = 0;
        while(n>0) {
            int ele = n%10;
            if(ele!=0) {
                x=x*10+ele;
                sum+=ele;
            }
            n/=10;
        }
        return sum*x;
    }
}