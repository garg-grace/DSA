class Solution {
    int mod = 1_000_000_007;
    List<String> columnStates = new ArrayList<>();
    char[] colours = {'R','G','B'};
    int[][] dp;
    private void generateColumnStates(String curr,char prevChar,int l,int m){
        if(l==m){
            columnStates.add(new String(curr));
            return;
        }
        for(char ch:colours){
            if(ch==prevChar) continue;

            generateColumnStates(curr+ch,ch,l+1,m);
        }
    }
    private int solve(int remainingCols,int prevIdx,int m){
        if(remainingCols==0) return 1;
        if(dp[remainingCols][prevIdx]!=-1) return dp[remainingCols][prevIdx];

        int ways=0;
        String prevState = columnStates.get(prevIdx);

        for(int i=0;i<columnStates.size();i++){
            if(i==prevIdx) continue;
            String currState = columnStates.get(i);
            boolean valid = true;

            for(int j=0;j<m;j++){
                if(prevState.charAt(j)==currState.charAt(j)){
                    valid = false;
                    break;
                }
            }

            if(valid == true){
                ways = (ways + solve(remainingCols-1,i,m))%mod;
            }
        }
        return dp[remainingCols][prevIdx] = ways;
    }
    public int colorTheGrid(int m, int n) {

        generateColumnStates("",'#',0,m);

        dp = new int[n+1][columnStates.size()];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

        int result = 0;
        for(int i=0;i<columnStates.size();i++){
            result = (result + solve(n-1,i,m))%mod; 
        }

        return result;        
    }
}