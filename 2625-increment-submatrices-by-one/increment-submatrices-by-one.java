class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] res = new int[n][n];
        
        for(int i=0;i<queries.length;i++) {
            int row1 = queries[i][0];
            int col1 = queries[i][1];
            int row2 = queries[i][2];
            int col2 = queries[i][3];

            res[row1][col1] += 1;
            if(col2+1<n) res[row1][col2+1] -= 1;

            if(row2+1<n) res[row2+1][col1] -= 1;
            if(row2+1<n && col2+1<n) res[row2+1][col2+1] += 1;        
        }


        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                res[i][j]+=res[i][j-1];
            }
        }

        for(int j=0;j<n;j++){
            for(int i=1;i<n;i++){
                res[i][j]+=res[i-1][j];
            }
        }
        return res;
    }
}