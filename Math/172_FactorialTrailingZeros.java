/***********************************************
Time Complexity : O(log n)
Space Complexity : O(1)
https://leetcode.com/problems/factorial-trailing-zeroes/
https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52367/My-explanation-of-the-Log(n)-solution
***********************************************/


class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        
        return zeroCount;
    }
}