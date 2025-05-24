class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        Integer[] delta = new Integer[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            delta[i] = (nums[i]^k) - nums[i];
            sum+=nums[i];
        }
        Arrays.sort(delta,(a,b)->b-a);

        for(int i=0;i<n;i+=2){
            if(i==n-1) break;
            int temp = delta[i]+delta[i+1];

            if(temp<=0) break;

            sum+=temp; 
        }
        return sum;        
    }
}