/**************************************************************************************************************************
Generating all combinations of well formed paranthesis is a typical example of catalan numbers.
Let time complexity for the generating all combinations of well-formed parentheses is f(n), then
f(n) = g(n) * h(n) where g(n) is the time complexity for calculating nth catalan number, and h(n) is the time required
to copy this combination to result array.
Therefore, f(n) = catalan(n) * O(n) which is O(4^n/n^1.5)*(n)). Broadly saying just remember that this is a typical example of 
catalan number and it's time complexity is similar to how catalan(n) is got.
https://leetcode.com/problems/generate-parentheses/
**************************************************************************************************************************/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> ans, String curr, int open, int close, int max) {
        // Base case
        if(curr.length() == max * 2) {
            ans.add(curr);
            return;
        }
        
        // Decisions
        if(open < max) {
            backtrack(ans, curr + "(", open + 1, close, max);
        }
        
        if(close < open) {
             backtrack(ans, curr + ")", open, close + 1, max);
        }
    }
}