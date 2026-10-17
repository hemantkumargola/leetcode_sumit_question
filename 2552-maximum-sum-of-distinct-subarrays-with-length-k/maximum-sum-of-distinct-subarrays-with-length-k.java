import java.util.HashSet;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int left = 0;

        long sum = 0;
        long maxSum = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < n; right++) {

            // Duplicate element ko remove karo
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            // Current element add karo
            set.add(nums[right]);
            sum += nums[right];

            // Window size k se badi hai
            if (right - left + 1 > k) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            // Window size k hai aur sabhi elements distinct hain
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}

/*Time Complexity: `O(n)`
Space Complexity: `O(k)` */