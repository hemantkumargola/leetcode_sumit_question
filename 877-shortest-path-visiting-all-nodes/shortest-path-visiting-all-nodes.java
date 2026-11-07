
class Solution {
    public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        int target = (1 << n) - 1;

        boolean[][] visited = new boolean[n][1 << n];

        Queue<int[]> q = new LinkedList<>();

        // Start BFS from every node
        for (int i = 0; i < n; i++) {

            int mask = (1 << i);

            q.add(new int[]{i, mask});
            visited[i][mask] = true;
        }

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.remove();

                int node = curr[0];
                int mask = curr[1];

                // All nodes visited
                if (mask == target) {
                    return steps;
                }

                // Visit neighbours
                for (int neighbor : graph[node]) {

                    int newMask = mask | (1 << neighbor);

                    if (!visited[neighbor][newMask]) {

                        visited[neighbor][newMask] = true;

                        q.add(new int[]{neighbor, newMask});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
// Time Complexity:  O((V + E) * 2^V)
// Space Complexity: O(V * 2^V)