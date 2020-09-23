/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/decode-ways/
https://www.youtube.com/watch?v=o1i7JYWbwOE
***********************************************/

class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for(int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            if(oneDigit >=1) {
                dp[i]+= dp[i-1];
            }
            
            if(twoDigits >= 10 && twoDigits <= 26) {
                dp[i]+= dp[i-2];
            }
            
        }
        return dp[s.length()];
    }
}