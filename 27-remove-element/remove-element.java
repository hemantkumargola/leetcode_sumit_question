class Solution {
    public int removeElement(int[] arr, int val) {
        int n = arr.length;
        int idx =0;
        for(int i =0;i<n;i++){
            if(arr[i]!=val){
                arr[idx]=arr[i];
                idx++;

            }
            

        }
    return idx;
    }
}

/*Time Complexity: O(n)
Auxiliary Space: O(1) */