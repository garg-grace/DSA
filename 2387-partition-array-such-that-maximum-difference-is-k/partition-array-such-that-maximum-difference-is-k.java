class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res=1;
        int n=nums.length;
        int first=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]-first>k){
                first=nums[i];
                res++;
            }
        }
        return res;
    }
}