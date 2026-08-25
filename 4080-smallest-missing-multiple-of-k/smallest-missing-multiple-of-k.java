class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<n; i++) {
            st.add(nums[i]);
        }

        for(int i=k; ; i+=k) {
            if(!st.contains(i)) return i;
        }
    }
}