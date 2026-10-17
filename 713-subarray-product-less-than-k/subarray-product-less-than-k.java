class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <=1) return 0;
        int count =0;
        int pro = 1;
        int left = 0;
        for(int rig = 0;rig<nums.length;rig++){
            pro *=nums[rig];
            while(pro>=k){
                pro /=nums[left];
               left++;

            }
            count +=(rig-left+1);

        }
        return count;
    }
}

/*Time Complexity:  O(n)
Space Complexity: O(1) */