//tebular methods in java 

//  class Solution {
//     public int climbStairs(int n) {
//         if(n<=2){
//             return n;

//         }
//         int pre2 = 1;
//         int pre1 = 2;
//         for(int i =3;i<=n;i++){
//             int curr = pre1+pre2;
//             pre2 = pre1;
//             pre1= curr;
//         }
//         return pre1;
//     }
// }



// memeoaztion methods in java 

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return solve(n, dp);
    }

    public int solve(int n, int[] dp) {
        if (n <= 2) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
        return dp[n];
    }
}
