
import java.util.*;

class Solution {
    public List<String> watchedVideosByFriends(
        List<List<String>> watchedVideos,
        int[][] friends,
        int id,
        int level
    ) {
        int n = friends.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        // BFS to reach the required level
        int currLevel = 0;

        while (!queue.isEmpty() && currLevel < level) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int person = queue.poll();

                for (int friend : friends[person]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }

            currLevel++;
        }

        // Count videos watched by friends at the required level
        Map<String, Integer> frequency = new HashMap<>();

        while (!queue.isEmpty()) {
            int person = queue.poll();

            for (String video : watchedVideos.get(person)) {
                frequency.put(
                    video,
                    frequency.getOrDefault(video, 0) + 1
                );
            }
        }

        // Sort by frequency, then alphabetically
        List<String> result = new ArrayList<>(frequency.keySet());

        Collections.sort(result, (a, b) -> {
            if (!frequency.get(a).equals(frequency.get(b))) {
                return frequency.get(a) - frequency.get(b);
            }
            return a.compareTo(b);
        });

        return result;
    }
}
