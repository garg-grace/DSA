class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int k=n-1;k>=0;k--){
            for(int j=k-1;j>=0;j--){
                for(int i=j-1;i>=0;i--){
                    if(nums[i]+nums[j]>nums[k]) return nums[i]+nums[j]+nums[k]; 
                }
            }
        }
        return 0;
    }
}