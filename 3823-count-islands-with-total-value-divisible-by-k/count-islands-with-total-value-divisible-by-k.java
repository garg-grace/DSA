class Solution {
    private int n,m=0;
    public int countIslands(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        int res = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]>0) {
                    long s = dfs(grid, i, j);
                    if(s%k == 0) res++;
                }
            }
        }
        return res;
    }

    private long dfs(int[][] grid, int i,int j) {
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0) {
            return 0;
        }
        
        long sum = grid[i][j];
        grid[i][j]=0;
        sum += dfs(grid,i-1,j);
        sum += dfs(grid,i+1,j);
        sum += dfs(grid,i,j-1);
        sum += dfs(grid,i,j+1);

        return sum;

    }
}