
import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Min Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return b.compareTo(a);
                }
                return map.get(a) - map.get(b);
            }
        );

        // Add words to heap
        for (String word : map.keySet()) {
            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Build answer
        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.reverse(ans);

        return ans;
    }
}
