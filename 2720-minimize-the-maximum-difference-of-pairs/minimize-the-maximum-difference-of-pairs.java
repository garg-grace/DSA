class Solution {
    private boolean isPossible(int diff,int[] nums,int p){
        int cnt=0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]<=diff){
                cnt++;
                i++;
            }
        }
        return cnt>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n-1]-nums[0];

        while(low<=high){
            int mid = low + (high-low)/2;
            if(isPossible(mid,nums,p)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;        
    }
}