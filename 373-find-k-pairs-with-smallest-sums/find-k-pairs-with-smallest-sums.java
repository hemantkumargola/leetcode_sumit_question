
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Add first k pairs
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        // Extract k smallest pairs
        while (!pq.isEmpty() && ans.size() < k) {

            int[] curr = pq.poll();

            int i = curr[1];
            int j = curr[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            // Add next pair from nums2
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return ans;
    }
}
