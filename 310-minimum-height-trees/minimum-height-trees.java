
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> ans = new ArrayList<>();

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        // Create adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] degree = new int[n];

        // Build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);

            degree[u]++;
            degree[v]++;
        }

        // Add all leaf nodes
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.add(i);
            }
        }

        int remaining = n;

        // Remove leaves level by level
        while (remaining > 2) {

            int size = q.size();

            remaining -= size;

            for (int i = 0; i < size; i++) {

                int curr = q.remove();

                for (int neighbor : graph[curr]) {

                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }

        // Remaining nodes are MHT roots
        while (!q.isEmpty()) {
            ans.add(q.remove());
        }

        return ans;
    }
}

/*Time Complexity:  O(V)
Space Complexity: O(V)*/
