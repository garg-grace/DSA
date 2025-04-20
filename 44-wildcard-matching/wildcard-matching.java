class Solution {
    private boolean f(int i,int j,String s,String p,int[][] dp){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(int jj=0;jj<=j;jj++){
                if(p.charAt(jj)!='*') return false;
            }
            return true;
        }

        if(dp[i][j]!=-1) return dp[i][j]==1;

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            boolean res = f(i-1,j-1,s,p,dp);
            dp[i][j]=(res==true)?1:0;
            return res;
        }else if(p.charAt(j)=='*'){
            boolean res = f(i-1,j,s,p,dp) || f(i,j-1,s,p,dp);
            dp[i][j]=(res==true)?1:0;
            return res;
        }

        dp[i][j]=0;
        return false;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return f(n-1,m-1,s,p,dp);        
    }
}