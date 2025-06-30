class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num:nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }

        int maxi=0;
        for(int num:freq.keySet()){
            if(freq.containsKey(num+1)){
                int len = freq.get(num)+freq.get(num+1);
                maxi = Math.max(maxi,len);
            }
        }
        return maxi;
    }
}