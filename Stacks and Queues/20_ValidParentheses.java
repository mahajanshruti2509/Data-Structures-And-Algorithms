/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/valid-parentheses/
***********************************************/

class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()==0) {
            return true;
        }

        if(s.length() % 2 !=0) {
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i< s.length(); i++) {
            char curr = s.charAt(i);
            if(map.keySet().contains(curr)) {
                stack.push(curr);
            } else if(map.values().contains(curr)) {
                if(!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}