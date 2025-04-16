class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i=0, j=0;
        long pairs=0 , res=0;
        HashMap<Integer,Integer> mp = new HashMap<>();

        while(j<n){
            pairs+=mp.getOrDefault(nums[j],0);
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);

            while(pairs>=k){
                res+=(n-j);
                mp.put(nums[i],mp.get(nums[i])-1);
                pairs-=mp.getOrDefault(nums[i],0);
                i++;
            }
            j++;
        }
        return res;
    }
}