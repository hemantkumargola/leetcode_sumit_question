class Solution {
    public boolean isPalindrome(String s) {
        int start =0;
        int end = s.length()-1;
        while(start<end){
        if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } 
            else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } 
           else{
            char l = Character.toLowerCase(s.charAt(start));
            char r  = Character.toLowerCase(s.charAt(end));

            if(l!=r){
                return false;
            }
            start++;
            end--;
           }
        }
        return true;
    }
}



/* Time Complexity: O(n)
Space Complexity: O(1)*/