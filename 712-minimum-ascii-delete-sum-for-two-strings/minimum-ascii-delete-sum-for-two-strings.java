class Solution {
    int[][] dp;
    String s1, s2;
    int n, m;

    private int solve(int i, int j) {
        if (i == n && j == m) return 0;

        // If one string is finished, delete remaining chars of the other
        if (i == n) {
            return dp[i][j] = s2.charAt(j) + solve(i, j + 1);
        }
        if (j == m) {
            return dp[i][j] = s1.charAt(i) + solve(i + 1, j);
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1);
        }

        int delete1 = s1.charAt(i) + solve(i + 1, j);
        int delete2 = s2.charAt(j) + solve(i, j + 1);

        return dp[i][j] = Math.min(delete1, delete2);
    }

    public int minimumDeleteSum(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        n = s1.length();
        m = s2.length();

        dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0);
    }
}
