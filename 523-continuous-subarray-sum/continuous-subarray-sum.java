import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 ko index -1 par store karo
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            int rem = sum % k;

            if (map.containsKey(rem)) {

                // Subarray ki length kam se kam 2 honi chahiye
                if (i - map.get(rem) >= 2) {
                    return true;
                }

            } else {
                // Sirf first occurrence store karo
                map.put(rem, i);
            }
        }

        return false;
    }
}