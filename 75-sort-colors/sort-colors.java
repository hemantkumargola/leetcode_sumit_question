class Solution {
    public void sortColors(int[] arr) {
        int n  = arr.length;
        int n0 =0;
        int n1 =0;
        for(int i = 0;i<n;i++){
            if(arr[i]==0) n0++;
            if(arr[i]==1) n1++;

        }
        for(int i=0;i<n;i++){
            if(i<n0) arr[i]=0;
            else if(i<n0+n1) arr[i]=1;
            else arr[i]=2;
        }
    }
}