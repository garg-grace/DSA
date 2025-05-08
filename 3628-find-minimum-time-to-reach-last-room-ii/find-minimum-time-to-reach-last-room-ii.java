class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        long INF = Long.MAX_VALUE/2;
        long[][][] dist = new long[n][m][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dist[i][j][0] = dist[i][j][1] = INF;
        dist[0][0][0] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0L, 0, 0, 0});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long t = cur[0];
            int x = (int)cur[1], y = (int)cur[2], p = (int)cur[3];
            if (t > dist[x][y][p]) continue;
            if (x == n-1 && y == m-1) return (int)t;
            int cost = (p == 0 ? 1 : 2), np = p ^ 1;
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    long w = moveTime[nx][ny];
                    long nt = Math.max(t, w) + cost;
                    if (nt < dist[nx][ny][np]) {
                        dist[nx][ny][np] = nt;
                        pq.offer(new long[]{nt, nx, ny, np});
                    }
                }
            }
        }
        return -1;
    }
}