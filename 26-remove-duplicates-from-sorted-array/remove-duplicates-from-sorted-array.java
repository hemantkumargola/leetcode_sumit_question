class Solution {
    public int removeDuplicates(int[] arr) {
        
        int  j =0;
        int n = arr.length;

        for(int i =0;i<n;i++){
            if(arr[i]!=arr[j]){
                j++;
                arr[j] = arr[i];
            }
        }
    return j+1;
    }
}

/*Time Complexity: O(n)
Space Complexity: O(1) */