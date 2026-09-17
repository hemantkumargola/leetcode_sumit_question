class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        // 0 = uncolored
        // 1 = color 1
        // 2 = color 2

        for (int i = 0; i < n; i++) {

            // New connected component
            if (color[i] != 0) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            color[i] = 1;

            while (!q.isEmpty()) {

                int node = q.poll();

                for (int neighbour : graph[node]) {

                    // Not colored
                    if (color[neighbour] == 0) {
                        color[neighbour] = 3 - color[node];
                        q.add(neighbour);
                    }

                    // Same color -> not bipartite
                    else if (color[neighbour] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}