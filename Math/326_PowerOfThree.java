/***********************************************
Time Complexity : O(log n) to the base 3
Space Complexity : O(1)
https://leetcode.com/problems/power-of-three/
***********************************************/

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        
        while (n % 3 == 0) {
            n /= 3;
        }
        
        return n == 1;
    }
}