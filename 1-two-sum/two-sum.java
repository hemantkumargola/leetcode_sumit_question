class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] ans = {-1,-1};
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i =0;i<nums.length;i++){
        int rem =target - nums[i];
        if(map.containsKey(rem)){
            ans[0] =i;
            ans[1] = map.get(rem);
           break ;
        }
        else{
            map.put(nums[i],i);
        }
       }
       return ans ;
    }
}
//try 











// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;
//         char[] cs = s.toCharArray();
//         char[] ct = t.toCharArray();
//         Arrays.sort(cs);
//         Arrays.sort(ct);

//         for(int i =0;i<cs.length;i++){
//             if(cs[i]!=ct[i])return false;
//         }
//         return true;
//     }
// }                                          