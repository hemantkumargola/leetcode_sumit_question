class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];

        // Initially, distance is infinity
        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        // Start from point 0
        minDist[0] = 0;

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            // Find unvisited point with minimum distance
            int u = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && (u == -1 || minDist[i] < minDist[u])) {
                    u = i;
                }
            }

            // Add this point to MST
            visited[u] = true;
            totalCost += minDist[u];

            // Update distance of remaining points
            for (int v = 0; v < n; v++) {

                if (!visited[v]) {

                    int distance = Math.abs(points[u][0] - points[v][0])
                                 + Math.abs(points[u][1] - points[v][1]);

                    if (distance < minDist[v]) {
                        minDist[v] = distance;
                    }
                }
            }
        }

        return totalCost;
    }
}