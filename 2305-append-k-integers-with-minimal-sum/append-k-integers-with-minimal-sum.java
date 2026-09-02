class Solution {
    public long minimalKSum(int[] nums, int k) {

        Arrays.sort(nums);

        long sum = 0;
        long current = 1;

        for (int num : nums) {

            if (current > num) {
                continue;
            }

            long count = num - current;

            if (count >= k) {
                sum += (long) k * current;
                sum += (long) k * (k - 1) / 2;
                return sum;
            }

            sum += count * (current + num - 1) / 2;
            k -= count;

            current = (long) num + 1;
        }

        sum += (long) k * current;
        sum += (long) k * (k - 1) / 2;

        return sum;
    }
}