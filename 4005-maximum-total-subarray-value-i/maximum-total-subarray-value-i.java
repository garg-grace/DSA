class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int num : nums) {
            if(num<min) min = num;
            if(num>max) max = num;
        }

        return (max-min)*k;
    }
}