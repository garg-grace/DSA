class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=0;i+k<=n;i++) {
            res = Math.min(res, nums[i+k-1]-nums[i]);
        }
        return res;
    }
}