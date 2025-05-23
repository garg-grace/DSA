class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            diff[l]+=1;
            if(r+1<n) diff[r+1]-=1;
        }
        for(int i=1;i<n;i++) diff[i]+=diff[i-1];

        for(int i=0;i<n;i++){
            if(diff[i]<nums[i]) return false;
        }
        return true;
    }
}