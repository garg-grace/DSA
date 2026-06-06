class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum+=num;
        }

        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for(int i=0; i<n; i++) {
            if(i>0) leftSum[i]=leftSum[i-1]+nums[i-1];
            if(i<n-1) rightSum[i]=totalSum-leftSum[i]-nums[i];
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = Math.abs(leftSum[i]-rightSum[i]);
        }
        return res;
    }
}