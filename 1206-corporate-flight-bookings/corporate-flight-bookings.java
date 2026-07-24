class Solution {
    public int[] corpFlightBookings(int[][] arr, int n) {
        int[] ans =  new int[n];
        for(int i =0;i<arr.length;i++){
            int  fir = arr[i][0];
            int last = arr[i][1];
            int seat= arr[i][2];
            ans[fir-1]+=seat;
            if(last<n) ans[last] -= seat;
            

        }
        for(int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }
}