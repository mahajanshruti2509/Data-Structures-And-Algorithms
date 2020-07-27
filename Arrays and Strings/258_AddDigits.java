/***********************************************
Time Complexity : O(1)
Space Complexity : O(1)
https://leetcode.com/problems/add-digits/
***********************************************/

class Solution {
    public int addDigits(int num) {
        if(num == 0) {
            return 0;
        }
        
        if(num % 9 == 0) { 
            // 81 % 9, 27 % 9, 63 % 9
            return 9;
        } else {
            // 83 % 9, 32 % 9, 65 % 9
            return num % 9;
        }
    }
}