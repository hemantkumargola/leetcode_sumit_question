
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();

        int dest = graph.length - 1;

        // Starting path
        List<Integer> start = new ArrayList<>();
        start.add(0);

        q.add(start);

        while (!q.isEmpty()) {

            // Remove current path
            List<Integer> curr = q.remove();

            // Get last node of current path
            int last = curr.get(curr.size() - 1);

            // Destination reached
            if (last == dest) {
                res.add(curr);
                continue;
            }

            // Visit all neighbours
            for (int neighbor : graph[last]) {

                // Create a new path
                List<Integer> newPath = new ArrayList<>(curr);

                newPath.add(neighbor);

                q.add(newPath);
            }
        }

        return res;
    }
}


// Time Complexity:  O(P * V + E)
// Space Complexity: O(P * V)