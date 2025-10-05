class Solution {
    int rows;
    int cols;

    private void dfs(int r, int c, int[][] vis, int h, int[][] heights){
        if(r<0 || r>=rows || c<0 || c>=cols || heights[r][c]<h || vis[r][c]==1){
            return;
        }

        vis[r][c]=1;
        dfs(r-1,c,vis,heights[r][c],heights);
        dfs(r,c+1,vis,heights[r][c],heights);
        dfs(r+1,c,vis,heights[r][c],heights);
        dfs(r,c-1,vis,heights[r][c],heights);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        int[][] pac = new int[rows][cols];
        int[][] atl = new int[rows][cols];

        for(int i=0;i<cols;i++){
            dfs(0, i, pac, heights[0][i], heights);
            dfs(rows-1, i, atl, heights[rows-1][i], heights);
        }

        for(int i=0;i<rows;i++){
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, cols-1, atl, heights[i][cols-1], heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pac[i][j]==1 && atl[i][j]==1){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
}