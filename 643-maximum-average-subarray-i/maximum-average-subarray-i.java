class Solution {
    public double findMaxAverage(int[] arr , int k) {
        int n  = arr.length;
        double sum = 0;
        for(int i = 0;i<k;i++){
            sum += arr[i];

        }
        double maxsum = sum;
        for(int i = k ;i<n;i++){
            sum+=arr[i];
            sum-=arr[i-k];
        
         maxsum = Math.max(maxsum,sum);
        
        }
        return maxsum/k;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)