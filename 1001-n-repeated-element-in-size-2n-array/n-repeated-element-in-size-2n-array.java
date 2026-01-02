class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int n = size/2;

        if(nums[n-2]==nums[n-1]) return nums[n-1];

        return nums[n];
    }
}