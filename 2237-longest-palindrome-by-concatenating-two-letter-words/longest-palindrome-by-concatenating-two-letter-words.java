class Solution {
    public int longestPalindrome(String[] words) {
        int[][] dp = new int[26][26];
        int len=0;

        for(String word:words){
            int i = word.charAt(0)-'a';
            int j = word.charAt(1)-'a';

            if(dp[j][i]>0){
                len+=4;
                dp[j][i]--;
            }else{
                dp[i][j]++;
            }
        }

        for(int i=0;i<26;i++){
            if(dp[i][i]>0){
                len+=2;
                break;
            }
        }
        return len;
    }
}