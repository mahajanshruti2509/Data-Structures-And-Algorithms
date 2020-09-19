/***********************************************
Time Complexity : O(n * n)
Space Complexity : O(1)
https://leetcode.com/problems/longest-palindromic-substring/
https://www.youtube.com/watch?v=DK5OKKbF6GI
***********************************************/

class Solution {
    
    int resultStart;
    int resultLength;
    
    public String longestPalindrome(String s) {
        int strLength = s.length();
        if(strLength < 2) {
            return s;
        }
        for(int start = 0; start < strLength; start++){
            expandRange(s, start, start); // 1 midpoint for odd length
            expandRange(s, start, start + 1); // 2 midpoints for even length
        }
        return s.substring(resultStart, resultStart + resultLength);
    }
    
    private void expandRange(String str, int begin, int end) {
        while(begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin --;
            end++;
        }
        
        if(resultLength < end - begin - 1) {
            resultStart = begin + 1; // increment by 1 to return back to the palindrome start
            resultLength = end - begin - 1;
        }
    }
}