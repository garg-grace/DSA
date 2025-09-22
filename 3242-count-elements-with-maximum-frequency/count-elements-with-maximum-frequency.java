class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;

        for(int num : nums){
            freq[num]++;
            if(freq[num]>maxFreq) maxFreq=freq[num];
        }

        int res=0;
        for(int i=0;i<101;i++){
            if(freq[i]==maxFreq) res+=maxFreq;
        }
        return res;
    }
}