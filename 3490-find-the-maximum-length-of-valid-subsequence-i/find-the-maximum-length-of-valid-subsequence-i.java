class Solution {
    public int maximumLength(int[] nums) {
        int odd=0;
        int even=0;
        int altEven=0;
        int altOdd=0;

        for(int num:nums){
            if(num%2==0){
                altEven=Math.max(altEven,altOdd+1);
                even++;
            }else{
                altOdd=Math.max(altOdd,altEven+1);
                odd++;
            }
        }
        return Math.max(Math.max(even,odd),Math.max(altOdd,altEven));
    }
}