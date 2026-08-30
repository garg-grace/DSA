class Solution {
    public int minimumDeletions(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        int minElement = Integer.MAX_VALUE;
        int minIndex = -1;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int ele = nums[i];
            if(ele > maxElement) {
                maxElement = ele;
                maxIndex = i;
            }
            if(ele < minElement) {
                minElement = ele;
                minIndex = i;
            }
        }

        int firstOption = Math.max(maxIndex,minIndex)+1;
        int secOption = n - Math.min(maxIndex,minIndex);
        int thirdOption = nums.length - Math.abs(maxIndex-minIndex) + 1;

        return Math.min(firstOption, Math.min(secOption, thirdOption));
    }
}