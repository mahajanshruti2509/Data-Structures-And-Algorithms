/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/climbing-stairs/
***********************************************/

class Solution {
    public int climbStairs(int n) {
        if(n < 0) {
            return 0;
        }
        if(n <= 1) {
           return 1; 
        }
        
        int[] dp = new int[n+1];
        dp[0] = 1; // 1 way : stay put
        dp[1] = 1; // 1 way to take 1 step
        dp[2] = 2; // 2 ways to take 2 steps : ((1 step + 1 step) or (2 steps in one go))
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}