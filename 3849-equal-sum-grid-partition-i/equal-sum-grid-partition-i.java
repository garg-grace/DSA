class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long totalSum = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                totalSum += grid[i][j];
            }
        }

        long temp = 0;
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m; j++) {
                temp += grid[i][j];
            }
            if(temp == (totalSum-temp)) return true;
        }

        temp = 0;
        for(int j=0; j<m-1; j++) {
            for(int i=0; i<n; i++) {
                temp += grid[i][j];
            }
            if(temp == (totalSum-temp)) return true;
        }

        return false;
        
    }
}