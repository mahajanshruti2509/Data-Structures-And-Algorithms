/***********************************************
Time Complexity : O(n*(2^n))
Explanation:
For a string with length n, there will be (n - 1) intervals between chars.
For every interval, we can cut it or not cut it, so there will be 2^(n - 1) ways to partition the string.
For every partition way, we need to check if it is palindrome, which is O(n).
So the time complexity is O(n*(2^n))

Space Complexity : O(2^n)

https://leetcode.com/problems/palindrome-partitioning/
https://www.youtube.com/watch?v=HXPucS3X3NA&t=1052s
https://leetcode.com/problems/palindrome-partitioning/discuss/182307/Java%3A-Backtracking-Template-General-Approach
https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
***********************************************/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        // Edge case
        if(s == null || s.length() == 0) {
            return result;
        }
        findAll(s, result, new ArrayList());
        return result;
    }
    
    void findAll(String s, List<List<String>> result, List<String> temp) {
         // Base case
        if(s.length() == 0) {
            result.add(new ArrayList(temp));
        }
        
        // RADAR
        for(int i = 0; i < s.length(); i++) { // R ADAR | RA DAR | RAD AR | RADA R| RADAR
            String leftPartition = s.substring(0, i+1); 
            if(isPalindrome(leftPartition)) { // Only do backtracking when current string is palindrome
                temp.add(leftPartition); // Choose
                String rightPartition = s.substring(i+1); 
                findAll(rightPartition, result, temp); // Explore
                temp.remove(temp.size() - 1); // Unchoose
            }
        }
    }
    
    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        
        if(left == right) {
            return true;
        }
        
        while( left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}