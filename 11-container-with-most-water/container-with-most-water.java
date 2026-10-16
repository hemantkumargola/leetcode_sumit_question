class Solution {
    public int maxArea(int[]  arr) {
        int n = arr.length;
        int s=0;
        int e = n-1;
        int count =0;
        while(s<e){
            int len = e-s;
            int wt = Math.min(arr[s],arr[e]);
            int area = len *wt;
             count = Math.max(count,area);
             if(arr[s]<arr[e]){
                s++;
             }
             else{
                e--;
             }
        }
        return count;
    }
}


/*// Time Complexity: O(N)
// Space Complexity: O(1)*/