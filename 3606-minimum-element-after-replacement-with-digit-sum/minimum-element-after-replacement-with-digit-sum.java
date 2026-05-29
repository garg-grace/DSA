class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;

        for(int num : nums) {
            int digitSum = calculateDigitSum(num);
            if(digitSum < res) res = digitSum;
        }

        return res;
    }

    private int calculateDigitSum(int num) {
        int sum = 0;
        while(num>0) {
            sum += num%10;
            num/=10;
        }

        return sum;
    }
}