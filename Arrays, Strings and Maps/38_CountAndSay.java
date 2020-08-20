/***********************************************
Time Complexity : O(2^n)
Space Complexity : O(n)
https://leetcode.com/problems/count-and-say/
***********************************************/

class Solution {
    public String countAndSay(int n) {
        if( n > 30) {
            return "";
        }
        
        String s = "1";
        for(int i = 1; i < n; i++) {
            s = countAndSayHelper(s);
        }
        return s;
    }
    
    public String countAndSayHelper(String s) {
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                count++;
            }
            else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        
        return sb.toString();
    }
}