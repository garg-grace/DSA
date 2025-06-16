class Solution {
    public int maximumDifference(int[] nums) {
        int diff=-1;
        int n = nums.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(j>i && nums[j]>nums[i]){
               int tempMax = nums[j] - nums[i];
                if(tempMax > diff){
                    diff = tempMax;
                }
            }else{
                i=j;
            }
        }
        return diff;
    }
}