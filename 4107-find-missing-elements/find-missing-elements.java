class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            if (nums[i - 1] + 1 == nums[i]) {
                continue;
            } else {
                for (int j = nums[i - 1] + 1; j < nums[i]; j++) {
                    ans.add(j);
                }
            }
        }

        return ans;
    }
}