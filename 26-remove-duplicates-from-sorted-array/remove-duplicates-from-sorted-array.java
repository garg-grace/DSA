class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int st = 0;

        for(int i=1; i<n; i++) {
            if(nums[i]!=nums[st]) nums[++st]=nums[i];
        }
        return st+1;
    }
}