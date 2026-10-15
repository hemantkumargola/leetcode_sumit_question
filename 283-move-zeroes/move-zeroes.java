class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j =0;j<nums.length;j++){
            if(nums[j]!=0){
                swap(nums,i,j);
                i++;

            }
        }
        
    }

    public static void  swap(int[] arr , int i ,int j){
        int tmep = arr[i];
        arr[i] = arr[j];
        arr[j] = tmep ;


    }
}

/*Time Complexity: O(n)
Space Complexity: O(1) */