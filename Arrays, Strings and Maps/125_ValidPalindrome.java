/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/valid-palindrome/
***********************************************/

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            
            if(i < j && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
}