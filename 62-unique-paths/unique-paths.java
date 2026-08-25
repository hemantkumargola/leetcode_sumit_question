// // soled recursion 
// class Solution {
//     public int uniquePaths(int m, int n) {
//       return  path(0,0,m,n); 
//     }
//     public int path(int row,int col , int m , int  n){
//         if(row>=m || col>=n) return 0;
//         if(row == m-1 || col == n-1)  return 1;
//         int rightway = path(row,col+1,m,n);
//         int letfway = path(row+1,col , m ,n );
//         return rightway + letfway;
//     }
// }






// solved memoazation 
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = -1;
            }
        }
         return  path(0,0,m,n,dp);
    }
         public int path(int row,int col , int m , int   n ,int[][] dp){
        if(row>=m || col>=n) return 0;
        if(row == m-1 || col == n-1)  return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int rightway = path(row,col+1,m,n,dp);
        int letfway = path(row+1,col , m ,n ,dp);
        return dp[row][col] = rightway + letfway;
    }
}



// // tabular methods 
// class Solution {
//     public int uniquePaths(int m, int n) {
        
//     }
// }   