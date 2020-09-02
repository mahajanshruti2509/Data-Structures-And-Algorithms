/***********************************************
Time Complexity : O(1)
Space Complexity : O(1)
https://leetcode.com/problems/valid-sudoku/
https://www.youtube.com/watch?v=rJ9NFK9s_mI
***********************************************/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char currCell = board[i][j];
                if(currCell != '.') {
                    String row = "row" + i + currCell;
                    String column = "column" + j + currCell;
                    String box = "box" + (i/3) * 3 +(j/3) + currCell;
                    
                    if(!seen.add(row) || !seen.add(column) || !seen.add(box)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}