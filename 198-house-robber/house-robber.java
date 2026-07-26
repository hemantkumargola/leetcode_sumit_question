class Solution {

      public int amount(int[] nums, int i, int[] dp) {
if(i>=nums.length) return 0;
if(dp[i]!=-1) return dp[i];
int take = nums[i] + amount(nums,i+2,dp);
int skip = amount(nums,i+1,dp);
return dp[i] = Math.max(take,skip);
}
public int rob(int[] nums) {
// 'i' varies from 0 to n-1
// dp[i] will store the value of amount(i)
int[] dp = new int[nums.length]; Arrays.fill(dp,-1);
return amount(nums,0,dp);
}  
    }





// class Solution {

//         public int rob(int[] arr) {
// int n = arr.length;
// int[] dp = new int[n];
// dp[0] = arr[0];
// if(n>1) dp[1] = Math.max(arr[0],arr[1]);
// for(int i=2;i<n;i++){
// dp[i] = Math.max(arr[i]+dp[i-2], dp[i-1]);
// }
// return dp[n-1];
// }
//     }
