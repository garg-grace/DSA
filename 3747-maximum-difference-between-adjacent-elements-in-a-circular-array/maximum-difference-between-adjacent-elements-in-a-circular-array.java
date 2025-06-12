class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int res=0;
        int n = nums.length;

        for(int i=0;i<n-1;i++){
            res=Math.max(res,Math.abs(nums[i]-nums[i+1]));
        }

        return Math.max(res,Math.abs(nums[n-1]-nums[0]));        
    }
}