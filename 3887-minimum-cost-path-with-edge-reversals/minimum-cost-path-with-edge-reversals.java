import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {

        List<int[]>[] out = new ArrayList[n];
        List<int[]>[] in = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i]   = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            out[u].add(new int[]{v, w});
            in[v].add(new int[]{u, w});
        }

        // dist[node][switchUsedAtNode]
        long[][] dist = new long[n][2];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[2]));

        dist[0][0] = 0;
        pq.add(new long[]{0, 0, 0}); // node, switchUsedAtNode, dist

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            int used = (int) cur[1];
            long d = cur[2];

            if (d != dist[u][used]) continue;
            if (u == n - 1) return (int) d;

            // normal outgoing u -> v
            for (int[] e : out[u]) {
                int v = e[0], w = e[1];
                if (d + w < dist[v][0]) {
                    dist[v][0] = d + w;
                    pq.add(new long[]{v, 0, d + w});
                }
            }

            // reverse any incoming v -> u
            if (used == 0) {
                for (int[] e : in[u]) {
                    int v = e[0], w = e[1];
                    long nd = d + 2L * w;
                    if (nd < dist[v][0]) {
                        dist[v][0] = nd;
                        pq.add(new long[]{v, 0, nd});
                    }
                }
            }
        }

        return -1;
    }
}
