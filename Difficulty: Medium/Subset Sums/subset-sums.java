import java.util.*;

class Solution {

    void func(int ind, int sum, int[] arr, ArrayList<Integer> ans) {

        if (ind == arr.length) {
            ans.add(sum);
            return;
        }

        // Pick
        func(ind + 1, sum + arr[ind], arr, ans);

        // Not Pick
        func(ind + 1, sum, arr, ans);
    }

    ArrayList<Integer> subsetSums(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        func(0, 0, arr, ans);

        Collections.sort(ans);

        return ans;
    }
}