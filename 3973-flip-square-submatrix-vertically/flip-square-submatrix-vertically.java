class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int diff=1;
        for(int i=x; i<x+k/2; i++) {
            for(int j=y; j<y+k; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i+k-diff][j];
                grid[i+k-diff][j]= temp;
            }
            diff+=2;
        }
        return grid;
    }
}