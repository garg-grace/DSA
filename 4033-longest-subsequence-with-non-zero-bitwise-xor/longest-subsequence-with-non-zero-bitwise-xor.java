class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean allZero = true;
        int resXor = 0;

        for(int num : nums) {
            resXor ^= num;

            if(num!=0) allZero = false;
        }

        if(allZero) return 0;

        return resXor==0 ? n-1 : n;
    }
}