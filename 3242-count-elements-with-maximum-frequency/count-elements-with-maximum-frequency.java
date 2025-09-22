class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        for(int num : nums){
            freq[num]++;
        }

        Arrays.sort(freq);
        int res=0;
        int maxi=freq[100];
        int i=100;
        while(i>=0 && freq[i]==maxi){
            res+=freq[i--];
        }
        return res;
    }
}