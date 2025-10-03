class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows= heightMap.length;
        int cols = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            visited[i][0]=true;
            visited[i][cols-1]=true;
            pq.offer(new int[]{heightMap[i][0],i,0});
            pq.offer(new int[]{heightMap[i][cols-1],i,cols-1});
        }

        for(int j=0;j<cols;j++){
            visited[0][j]=true;
            visited[rows-1][j]=true;
            pq.offer(new int[]{heightMap[0][j],0,j});
            pq.offer(new int[]{heightMap[rows-1][j],rows-1,j});
        }

        int ans=0;
        int maxHeight = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int h=curr[0],r=curr[1],c=curr[2];
            maxHeight=Math.max(maxHeight,h);
            ans+=maxHeight-h;

            int[][] neighbours = new int[][]{{r,c-1},{r-1,c},{r,c+1},{r+1,c}};
            for(int[] neighbour :neighbours){
                int nr = neighbour[0];
                int nc = neighbour[1];
                if(nr<0 || nc<0 || nr==rows || nc==cols || visited[nr][nc]) continue;

                pq.offer(new int[]{heightMap[nr][nc],nr,nc});
                visited[nr][nc]=true;
            }
        }

        return ans;      
    }
}