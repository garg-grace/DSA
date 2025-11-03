class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        char prev  = colors.charAt(0);
        int maxi = neededTime[0];
        int sum = neededTime[0];

        for(int i=1;i<n;i++) {
            char curr = colors.charAt(i);
            if(prev == curr) {
                maxi = Math.max(maxi,neededTime[i]);
                sum += neededTime[i];
            }else {
                sum -= maxi;
                maxi = neededTime[i];
                sum += neededTime[i];
                prev = curr;
            }
        }
        
        return sum-maxi;
    }
}