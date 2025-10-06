class Tuple {
    int row;
    int col;
    int time;
    public Tuple(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.add(new Tuple(0,0,grid[0][0]));
        vis[0][0]=1;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int row = t.row;
            int col = t.col;
            int time = t.time;
            if(row==n-1 && col==m-1) return time;

            for(int i=0; i<4; i++){
                int nrow = row+dr[i];
                int ncol = col+dc[i];
                if(nrow<0 || nrow>=n || ncol<0 || ncol>=m || vis[nrow][ncol]==1){
                    continue;
                }

                if(time>=grid[nrow][ncol]){
                    pq.add(new Tuple(nrow,ncol,time));
                }else{
                    pq.add(new Tuple(nrow,ncol,grid[nrow][ncol]));
                }
                vis[nrow][ncol]=1;
            }
        }
        return 0;
    }
}