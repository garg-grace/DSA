class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int st = 2;

        for(int i=2; i<n; i++) {
            if(nums[i]!=nums[st-2]) nums[st++]=nums[i];
        }
        return st;
        
    }
}