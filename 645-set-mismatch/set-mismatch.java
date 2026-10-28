class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;

        // Step 1: Find duplicate using marking
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] < 0)
                dup = val;  // already seen -> duplicate
            else
                nums[val - 1] *= -1; // mark as seen
        }

        // Step 2: Find missing
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }

        return new int[]{dup, missing};
    }
}
