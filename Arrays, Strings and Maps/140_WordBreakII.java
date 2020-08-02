/***********************************************
Time Complexity : O(2^n)
Space Complexity : O(2^n)
https://leetcode.com/problems/word-break-ii/
https://www.youtube.com/watch?v=uR3RElKnrkU
***********************************************/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    public List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List<String>> memo) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> result = new ArrayList<>();
        // Base Case
        if(s.length() == 0) {
            result.add("");
            return result;
        }
        
        // Break the string apart and append the substrings to the first word(s)
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String remainingString = s.substring(word.length());
                List<String> subStrings = wordBreakHelper(remainingString, wordDict, memo);
                
                for(String eachWord : subStrings) {
                    String space = eachWord.isEmpty() ? "" : " ";
                    result.add(word + space + eachWord);
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}