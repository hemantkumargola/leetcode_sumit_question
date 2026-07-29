import java.util.*;

class Solution {

    private void solve(int index, int[] arr, int target,
                       List<Integer> ds,
                       List<List<Integer>> ans) {

        // Base Case
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Skip duplicates
            if (i > index && arr[i] == arr[i - 1])
                continue;

            // Since array is sorted
            if (arr[i] > target)
                break;

            ds.add(arr[i]);

            // Move to next index (cannot reuse same element)
            solve(i + 1, arr, target - arr[i], ds, ans);

            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }
}