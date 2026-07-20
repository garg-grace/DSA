class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        
        // Optimize k if it exceeds total grid size
        k = k % total;
        
        // Initialize the output matrix
        int[][] result = new int[m][n];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int newIndex = (r * n + c + k) % total;
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                result[newRow][newCol] = grid[r][c];
            }
        }
        
        // Convert int[][] to List<List<Integer>> as required
        List<List<Integer>> output = new ArrayList<>();
        for (int[] row : result) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row) {
                listRow.add(val);
            }
            output.add(listRow);
        }
        
        return output;
    }
}