class Solution {
    public int countSubarrays(int[] nums) {
        int n=nums.length;
        int cnt=0;
        double a=nums[0],b=nums[1];
        for(int i=2;i<n;i++){
            if(a+nums[i]==b/2) cnt++;

            a=b;
            b=nums[i];
        }
        return cnt;
    }
}