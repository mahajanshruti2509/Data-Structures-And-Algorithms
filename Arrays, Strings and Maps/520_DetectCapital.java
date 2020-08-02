/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/detect-capital/
***********************************************/

class Solution {
    public boolean detectCapitalUse(String word) {
        int capital = 0;
        int small = 0;
        for(int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if(currChar >= 65 && currChar <= 90) {
                capital++;
            } else {
                small++;
            }
        }
        
        boolean areAllLettersCapital = capital == word.length();
        boolean areAllLettersSmall = small == word.length();
        boolean isOnlyFirstLetterCapital = (capital == 1 && word.charAt(0) >= 65 && word.charAt(0) <= 90);
        return (areAllLettersCapital || areAllLettersSmall || isOnlyFirstLetterCapital);
    }
}