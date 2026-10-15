class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start<end){
            int sum = arr[start]+arr[end];

            if(sum==target){
                int[] result = {start+1,end+1};
                return result;

            }
            else if(sum<target){
                start++;

            }
            else{
                end--;

            }
        }
    int[] result = new int[0];
       return result;

    }
}


/*Time Complexity: O(n)
Auxiliary Space: O(1) */