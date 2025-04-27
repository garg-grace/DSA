class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String reversed = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        int maxi = 0;
        int endIndex = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    
                    int originalIndex = i - dp[i][j];
                    int reversedIndex = n - j;
                    if (originalIndex == reversedIndex && dp[i][j] > maxi) {
                        maxi = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        return s.substring(endIndex - maxi, endIndex);
    }
}
