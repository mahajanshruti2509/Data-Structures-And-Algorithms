/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/excel-sheet-column-number/
***********************************************/

class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++) {
            // Decimal 65 in ASCII corresponds to char 'A'
            int c = i + 65;
            map.put( (char) c, i + 1);
        }
        
        int strLength = s.length();
        for(int i = 0; i < strLength; i++) {
            char currRightChar = s.charAt(strLength - 1 - i);
            result += (map.get(currRightChar) * Math.pow(26, i)); 
        }
        return result;
    }
}