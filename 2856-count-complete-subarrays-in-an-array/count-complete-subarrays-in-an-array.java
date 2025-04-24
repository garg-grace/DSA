class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int distinct = (int)Arrays.stream(nums).distinct().count();
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();
        int left=0;
        int res=0;
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            while(mp.size()==distinct){
                res+=(n-i);
                mp.put(nums[left],mp.get(nums[left])-1);
                if(mp.get(nums[left])==0) mp.remove(nums[left]);
                left++;              
            }
        }
        return res;
    }
}