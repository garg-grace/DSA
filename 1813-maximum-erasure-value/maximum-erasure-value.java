class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> st = new HashSet<>();
        int maxi=-1;
        int sum=0;
        int left=0;

        for(int i=0;i<nums.length;i++){
            while(st.contains(nums[i])){
                st.remove(nums[left]);
                sum-=nums[left++];
            }
            
            st.add(nums[i]);
            sum+=nums[i];
            maxi=Math.max(sum,maxi);
        }
        return maxi;
    }
}