/***********************************************
Time Complexity : O(n^2)
Space Complexity : O(1)
https://leetcode.com/problems/find-the-celebrity/
***********************************************/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        if (n == 1) return 0;
        
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            /* Two possibilities:
            1) knows (candidate, i) -> true, candidate is not a celebrity since candidate knows i. i can be a potential candidate, so update candidate to i
            2) knows (candidate, i) -> false, i is not a celebrity since everyone must know i. candidate is a potential celebrity, so no need to update candidate value
            */
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(candidate != i && knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        
        return candidate;
    }
}