class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        // dist[i][j] = minimum effort to reach (i, j)
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // {effort, row, col}
        java.util.PriorityQueue<int[]> pq =
            new java.util.PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int effort = current[0];
            int row = current[1];
            int col = current[2];

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            // Already found a better path
            if (effort > dist[row][col]) {
                continue;
            }

            for (int[] dir : directions) {

                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int edgeEffort =
                    Math.abs(heights[row][col] - heights[nr][nc]);

                // Maximum effort on this new path
                int newEffort = Math.max(effort, edgeEffort);

                if (newEffort < dist[nr][nc]) {

                    dist[nr][nc] = newEffort;

                    pq.offer(new int[]{
                        newEffort, nr, nc
                    });
                }
            }
        }

        return 0;
    }
}