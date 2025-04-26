class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long cnt=0;
        int maxPos=-1,minPos=-1,culpritPos=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<minK || nums[i]>maxK) culpritPos=i;
            if(nums[i]==minK) minPos=i;
            if(nums[i]==maxK) maxPos=i;

            int temp = Math.min(minPos,maxPos)-culpritPos;

            if(temp>0) cnt+=temp;
        }
        return cnt;
    }
}