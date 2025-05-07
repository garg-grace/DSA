class Tuple{
    int time;
    int row;
    int col;
    public Tuple(int t,int r,int c){
        this.time=t;
        this.row=r;
        this.col=c;
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dis = new int[n][m];
        for(int[] d:dis) Arrays.fill(d,Integer.MAX_VALUE);
        dis[0][0]=0;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->x.time-y.time);
        pq.offer(new Tuple(0,0,0));
        
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Tuple it = pq.poll();
            int time = it.time;
            int row = it.row;
            int col = it.col;
            if(row==n-1 && col==m-1) return time;
            
            for(int i=0;i<4;i++){
                int drow = row+dr[i];
                int dcol = col+dc[i];
                if(drow<0 || drow>=n || dcol<0 || dcol>=m) continue;

                int waitTime = Math.max(0,moveTime[drow][dcol]-time);
                int arriveTime = time+1+waitTime;
                if(arriveTime<dis[drow][dcol]){
                    pq.offer(new Tuple(arriveTime,drow,dcol));
                    dis[drow][dcol]=arriveTime;
                }
            }

        }
        return -1;       
    }
}