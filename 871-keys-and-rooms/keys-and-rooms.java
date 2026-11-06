import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        // Start from room 0
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {

            int room = q.remove();

            // Current room ki saari keys
            for (int key : rooms.get(room)) {

                // Agar room visit nahi hua
                if (!visited[key]) {

                    visited[key] = true;
                    q.add(key);
                }
            }
        }

        // Check: kya saare rooms visit hue?
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}  

// Time Complexity:  O(V + E)
// Space Complexity: O(V)