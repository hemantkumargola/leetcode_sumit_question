class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            // Destination found
            if (curr == destination) {
                return true;
            }

            for (int neighbor : graph[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        return false;
    }
}