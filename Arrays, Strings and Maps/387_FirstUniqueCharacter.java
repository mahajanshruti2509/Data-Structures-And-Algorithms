/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/first-unique-character-in-a-string/
***********************************************/

class Solution {
    public int firstUniqChar(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        int[] hash = new int[26];
        
        for(char c : s.toCharArray()) {
            hash[c] = hash[c] + 1;
        }
        for(int i = 0; i< s.length(); i++) {
            if(hash[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}