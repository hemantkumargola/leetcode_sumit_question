class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] larr = new long[nums.length];
        int n = larr.length;
        int mx = 0;
        for(int i =0;i<n;i++){
            mx = Math.max(mx,nums[i]);
            larr[i] = (long) nums[i] +mx;
        }
        for(int i =1;i<n;i++){
            larr[i] +=larr[i-1];
        }
        return larr;
        
    }
}