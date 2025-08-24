class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int left = 0;
        int zeroes = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeroes++;
                while(zeroes > 1) {
                    int val = nums[left++];
                    if(val == 0) zeroes--;
                }
            }
            result = Math.max(result, right - left );
        }
        return result;
        
    }
}