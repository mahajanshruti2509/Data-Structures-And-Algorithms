/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/happy-number/
***********************************************/

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seenSum = new HashSet<Integer>();
        while(!seenSum.contains(n)) {
            seenSum.add(n);
            n = computeSumOfSquares(n);
            if(n == 1) {
                return true;
            } 
        }
        return false;
    }
    
    private int computeSumOfSquares(int number) {
        int sum = 0; 
        int lastDigit = 0;
        int remainingNumber =0;
        
        while(number > 0) {
            lastDigit = number % 10;
            sum = sum + (lastDigit * lastDigit);
            remainingNumber = number / 10;
            number = remainingNumber;
        }
        return sum;
    }
}