class Solution {
    public int largestAltitude(int[] gain) {
        int at= 0;
        int mx = 0;

        int n = gain.length;
        for(int i=0;i<n;i++){
            at += gain[i];
            mx = Math.max(mx,at);

        }
        return mx;
    }
}