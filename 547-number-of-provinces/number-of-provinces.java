class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            // Agar city already visit nahi hui
            if (!visited[i]) {

                provinces++;

                // BFS start
                bfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    public void bfs(int start, int[][] graph, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {

            int city = q.remove();

            // Saare connected cities check karo
            for (int j = 0; j < graph.length; j++) {

                if (graph[city][j] == 1 && !visited[j]) {

                    visited[j] = true;
                    q.add(j);
                }
            }
        }
    }
}