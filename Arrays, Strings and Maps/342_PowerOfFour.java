/***********************************************
Time Complexity : O(1)
Space Complexity : O(1)
https://leetcode.com/problems/power-of-four/
***********************************************/

class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && (Math.log(num) / Math.log(2) % 2 == 0);
    }
}