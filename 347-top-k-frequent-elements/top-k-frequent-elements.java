class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : map.keySet()) {

            pq.add(new int[]{key, map.get(key)});

            if (pq.size() > k)
                pq.remove();
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.remove()[0];
        }

        return ans;
    }
}

// Time Complexity: O(n log k)
// Space Complexity: O(n + k)