import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of every course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            // prerequisite -> course
            graph.get(prerequisite).add(course);

            // Increase indegree of course
            indegree[course]++;
        }

        // Queue for courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Count completed courses
        int count = 0;

        // Kahn's Algorithm
        while (!queue.isEmpty()) {

            int course = queue.poll();

            count++;

            // Visit all dependent courses
            for (int neighbour : graph.get(course)) {

                indegree[neighbour]--;

                // No prerequisite remaining
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        // If all courses are processed,
        // there is no cycle.
        return count == numCourses;
    }
}