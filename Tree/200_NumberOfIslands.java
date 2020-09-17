/***********************************************
Time Complexity : O(mn)
Space Complexity : O(mn)
https://leetcode.com/problems/number-of-islands/
***********************************************/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    
    private int dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[i].length || grid[i][j] =='0') {
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i-1, j); // top
        dfs(grid, i+1, j); // bottom
        dfs(grid, i, j-1); // left
        dfs(grid, i, j+1); // right
        // After exploring all neighbouring cells and marking those cells as visited, return '1' as a squashed result.
        return 1;
    }
}