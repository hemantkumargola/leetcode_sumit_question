class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        for(int i =1;i<n;i++){
            nums[i] += nums[i-1];

        }
        for(int i =0;i<n;i++){
            int left = 0;
            if(i>0) left = nums[i-1];
            int right = nums[n-1] - nums[i];
            if(left==right){
                return i;
            }
        }
        return -1;
    }
}