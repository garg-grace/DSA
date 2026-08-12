class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int maxLen = 0;
        int st = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int num = nums[i];
            mp.put(num, mp.getOrDefault(num,0)+1);

            int freq = mp.get(num);
            while(freq>k) {
                int stFreq = mp.get(nums[st]);
                mp.put(nums[st], stFreq-1);
                if(nums[st] == num) freq--;
                st++;
            }

            maxLen = Math.max(maxLen, i-st+1);
        }
        return maxLen;
    }
}