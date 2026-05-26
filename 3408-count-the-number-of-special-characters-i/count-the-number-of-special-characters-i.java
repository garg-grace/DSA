class Solution {
    public int numberOfSpecialChars(String word) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch : word.toCharArray()) {
            if(ch-'a'>=0 && ch-'a'<26){
                freq1[ch-'a']++;
            }else {
                freq2[ch-'A']++;
            }
        }

        int res = 0;
        for(int i=0; i<26; i++) {
            if(freq1[i]>0 && freq2[i]>0) res++;
        }
        return res;
    }
}