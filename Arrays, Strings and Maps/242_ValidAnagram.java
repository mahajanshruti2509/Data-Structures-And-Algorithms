/***********************************************
Time Complexity : O(n)
Space Complexity : O(1). Although we do use extra space, the space complexity is O(1)
because the table's size stays constant no matter how large n is.
https://leetcode.com/problems/valid-anagram/
***********************************************/


class Solution {
    public boolean isAnagram(String s, String t) {
        if( (s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return true;
        }
        
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if(alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;    
    }
}