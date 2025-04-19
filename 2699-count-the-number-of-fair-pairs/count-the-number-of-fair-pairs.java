class Solution {
    private long solve(int[] nums,int x){
        long ans = 0;
        int j = nums.length-1;
        for(int i=0;i<j;i++){
            while(i<j && nums[i]+nums[j]>x) j--;
            ans+=(j-i);
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return solve(nums,upper)-solve(nums,lower-1);        
    }
}