
import java.util.*;

class Solution {

    int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        // Create adjacency list
        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, graph, tin, low, bridges);

        return bridges;
    }

    void dfs(int node, int parent,
             ArrayList<Integer>[] graph,
             int[] tin, int[] low,
             List<List<Integer>> bridges) {

        // Discovery time
        tin[node] = low[node] = timer++;

        for (int neighbor : graph[node]) {

            // Skip parent
            if (neighbor == parent) {
                continue;
            }

            // If already visited
            if (tin[neighbor] != 0) {

                low[node] = Math.min(low[node], tin[neighbor]);

            } else {

                // DFS call
                dfs(neighbor, node, graph, tin, low, bridges);

                // Update low value
                low[node] = Math.min(low[node], low[neighbor]);

                // Check bridge condition
                if (low[neighbor] > tin[node]) {

                    bridges.add(Arrays.asList(node, neighbor));
                }
            }
        }
    }
}
