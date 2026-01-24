class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxSum = 0;

        for(int i=0; i<n/2; i++) {
            maxSum = Math.max(maxSum, nums[i]+nums[n-i-1]);
        }

        return maxSum;
    }
}