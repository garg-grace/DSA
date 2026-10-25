class Solution {
    private int n,m=0;
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int islands = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0 && dfs(grid,i,j)) islands++;
            }
        }
        return islands;
    }

    private boolean dfs(int[][] grid, int i,int j) {
        if(i<0 || j<0 || i>=n || j>=m) {
            return false;
        }
        if(grid[i][j]==1) return true;

        grid[i][j]=1;
        boolean left = dfs(grid,i-1,j);
        boolean right = dfs(grid,i+1,j);
        boolean up = dfs(grid,i,j-1);
        boolean down = dfs(grid,i,j+1);

        return left && right && up && down;

    }
}