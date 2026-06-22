class Solution {
    public int maxNumberOfBalloons(String text) {

        int[] freq = new int[26];
        for(char ch : text.toCharArray()) {
            freq[ch-'a']++;
        }

        int res = text.length();

        char[] bal = {'b','a','l','o','n'};
        for(char b : bal) {
            if(b=='l' || b=='o') freq[b-'a']/=2;
            res = Math.min(res, freq[b-'a']);
        }
        return res;
    }
}