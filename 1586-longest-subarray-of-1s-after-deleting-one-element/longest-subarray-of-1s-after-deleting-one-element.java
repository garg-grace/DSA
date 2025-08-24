class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int res=0;
        int n=nums.length;
        int zeroCnt=0;

        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zeroCnt++;
                while(zeroCnt>1){
                    if(nums[left]==0)  zeroCnt--;
                    left++;
                }
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}