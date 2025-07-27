class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int left=1;
        for(int right=1;right<n;right++){
            if(nums[left-1]!=nums[right]){
                nums[left]=nums[right];
                left++;
            }
        }

        int cnt=0;
        for(int i=1;i<left-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                cnt++;
            }else if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                cnt++;
            }
        }
        return cnt;
    }
}