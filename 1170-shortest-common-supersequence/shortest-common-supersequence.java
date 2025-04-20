class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int ptr1=n,ptr2=m;
        while(ptr1>0 && ptr2>0){
            if(str1.charAt(ptr1-1)==str2.charAt(ptr2-1)){
                sb.append(str1.charAt(ptr1-1));
                ptr1--;
                ptr2--;
            }else if(dp[ptr1-1][ptr2]>dp[ptr1][ptr2-1]){
                sb.append(str1.charAt(ptr1-1));
                ptr1--;
            }else{
                sb.append(str2.charAt(ptr2-1));
                ptr2--;
            }
        }
        while(ptr1>0){
            sb.append(str1.charAt(ptr1-1));
            ptr1--;
        }
        while(ptr2>0){
            sb.append(str2.charAt(ptr2-1));
            ptr2--;
        }
        return sb.reverse().toString();
    }
}