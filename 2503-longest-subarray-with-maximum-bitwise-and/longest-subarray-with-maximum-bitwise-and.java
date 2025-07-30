class Solution {
    public int longestSubarray(int[] nums) {
        int len = 1;

        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max= Math.max(max,num);
        }

        int itr=0;
        for(int num:nums){
            if(num==max){
                itr++;
            }else{
                len = Math.max(len,itr);
                itr=0;
            }
        }
        
        len = Math.max(len,itr);

        return len;
    }
}