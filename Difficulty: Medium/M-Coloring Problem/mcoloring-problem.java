class Solution {

    boolean graphColoring(int v, int[][] edges, int m) {

        // Adjacency Matrix
        boolean[][] graph = new boolean[v][v];

        for (int[] e : edges) {
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
        }

        int[] color = new int[v];

        return colorGraph(0, graph, color, m, v);
    }

    // Backtracking Function
    private boolean colorGraph(int node, boolean[][] graph, int[] color, int m, int v) {

        // All vertices are colored
        if (node == v)
            return true;

        // Try every color
        for (int c = 1; c <= m; c++) {

            if (isSafe(node, graph, color, c, v)) {

                color[node] = c;          // Choose

                if (colorGraph(node + 1, graph, color, m, v))
                    return true;

                color[node] = 0;          // Backtrack
            }
        }

        return false;
    }

    private boolean isSafe(int node, boolean[][] graph, int[] color, int c, int v) {

        for (int i = 0; i < v; i++) {
            if (graph[node][i] && color[i] == c)
                return false;
        }

        return true;
    }
}