class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curmax = 0;
        int maxsum = Integer.MIN_VALUE;
        int curmin = 0;
        int minsum = Integer.MAX_VALUE;
        int total = 0;
        for(int num :nums){
            curmax = Math.max(num ,curmax+num);
            maxsum = Math.max(curmax,maxsum);

            curmin = Math.min(num,curmin+num);
            minsum = Math.min(curmin,minsum);

            total+=num;

        }
        if(maxsum<0){
            return  maxsum;
        }
        return Math.max(maxsum,total-minsum);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)