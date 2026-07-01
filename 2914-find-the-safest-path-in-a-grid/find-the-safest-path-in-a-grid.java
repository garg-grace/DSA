class Solution {
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
            return 0;
        }

        int[][] dist = new int[n][n];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0; // Distance to itself is 0
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == Integer.MAX_VALUE) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Binary Search on Maximum Safeness Factor
        int left = 0, right = n * n, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canReachDestination(grid, dist, mid, n)) {
                ans = mid;
                left = mid + 1; // Try a higher safeness factor
            } else {
                right = mid - 1; // Reduce safeness factor
            }
        }

        return ans;
    }

    private boolean canReachDestination(List<List<Integer>> grid, int[][] dist, int safeLimit, int n) {
        if (dist[0][0] < safeLimit) return false; // Start cell isn't safe enough

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            if (r == n - 1 && c == n - 1) return true; // Reached destination

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    !visited[nr][nc] && dist[nr][nc] >= safeLimit) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}