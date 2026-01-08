class Solution {
    int n, m;
    int[][] dp;

    private int solve(int[] nums1, int[] nums2, int i, int j) {
        if (i == n || j == m) return (int)-1e9;

        if (dp[i][j] != -1_000_000_000) return dp[i][j];

        int prod = nums1[i] * nums2[j];

        int takeBoth = prod + solve(nums1, nums2, i + 1, j + 1); // continue
        int startHere = prod;                                   // start new
        int skip1 = solve(nums1, nums2, i + 1, j);               // skip nums1[i]
        int skip2 = solve(nums1, nums2, i, j + 1);               // skip nums2[j]

        return dp[i][j] = Math.max(
            Math.max(startHere, takeBoth),
            Math.max(skip1, skip2)
        );
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        n = nums1.length;
        m = nums2.length;

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1_000_000_000);
        }

        return solve(nums1, nums2, 0, 0);
    }
}
