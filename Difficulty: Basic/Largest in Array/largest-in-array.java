class Solution {
    public static int largest(int[] arr) {
        // code here
        int mx = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>mx){
                mx = arr[i];
            }
            
        }
        return mx;
    }
}
