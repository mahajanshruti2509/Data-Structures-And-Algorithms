/***********************************************
Time Complexity : O(n + m)
Space Complexity : O(1)
https://leetcode.com/problems/search-a-2d-matrix-ii/
***********************************************/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int currRow = 0;
        int currCol = n - 1;
        
        while(currRow < m && currCol >= 0) {
            if(matrix[currRow][currCol] == target) {
                return true;
            }
            
            if(matrix[currRow][currCol] > target) {
                currCol--;
            } else {
                currRow++;
            }
        }
        return false;
    }
}