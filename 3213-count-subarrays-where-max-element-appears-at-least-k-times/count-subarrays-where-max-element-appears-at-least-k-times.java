class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi = 0;
        for(int num:nums) if(maxi<num) maxi=num;
        int cnt=0;
        int left=0;
        long res=0;
        int n =nums.length;
        for(int right=0;right<n;right++){
            if(maxi==nums[right]) cnt++;

            while(cnt>=k){
                if(nums[left]==maxi) cnt--;
                left++;
                res+=(n-right);
            }
        }
        return res;
    }
}