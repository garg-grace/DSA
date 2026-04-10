class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int cnt=0;
            for(int j=i; j<n; j++) {
                if(nums[i]==nums[j]) {
                    cnt++;
                    if(cnt==3) {
                        res = Math.min(res,2*(j-i));
                        break;
                    }
                }
            }
        }

        return res==Integer.MAX_VALUE ? -1 : res;
    }
}