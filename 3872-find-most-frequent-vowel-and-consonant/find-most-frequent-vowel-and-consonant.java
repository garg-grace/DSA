class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        int mv=0;
        int mc=0;
        for(int i=0;i<26;i++){
            if("aeiou".indexOf('a'+i)>=0){
                mv=Math.max(mv,freq[i]);
            }else{
                mc=Math.max(mc,freq[i]);
            }
        }
        return mv+mc;
    }
}