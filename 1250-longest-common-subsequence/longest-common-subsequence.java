class Solution {
    private int f(int n1,int n2,String text1,String text2,int[][] dp){
        if(n1<0 || n2<0) return 0;
        if(dp[n1][n2]!=-1) return dp[n1][n2];

        if(text1.charAt(n1)==text2.charAt(n2)) return dp[n1][n2]=1+f(n1-1,n2-1,text1,text2,dp);

        return dp[n1][n2]=Math.max(f(n1-1,n2,text1,text2,dp),f(n1,n2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(),n2=text2.length();
        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++) Arrays.fill(dp[i],-1);
        return f(n1-1,n2-1,text1,text2,dp);        
    }
}