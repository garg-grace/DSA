class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> freq = new HashMap<>();
        int st = 0;
        int n = s.length();
        int maxLen = 0;

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0)+1);

            while(freq.get(ch)>2) {
                char stChar = s.charAt(st);
                freq.put(stChar, freq.get(stChar)-1);
                st++;
            }

            maxLen = Math.max(maxLen, i-st+1);
        }

        return maxLen;
    }
}