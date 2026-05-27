class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lowerCaseFreq = new int[26];
        int[] upperCaseFreq = new int[26];

        for(char ch : word.toCharArray()) {
            if(Character.isLowerCase(ch)) {
                //handle lowercase
                int idx = ch-'a';
                lowerCaseFreq[idx]++;
                if(upperCaseFreq[idx]>0) upperCaseFreq[idx]=-1;
                
            } else {
                //handle upperCase
                int idx = ch-'A';
                if(upperCaseFreq[idx]==-1) continue;

                upperCaseFreq[idx]++;
            }
        }

        int res = 0;
        for(int i=0; i<26; i++) {
            if(upperCaseFreq[i]==-1) continue;

            if(upperCaseFreq[i]>0 && lowerCaseFreq[i]>0) res++;
        }
        return res;
    }
}