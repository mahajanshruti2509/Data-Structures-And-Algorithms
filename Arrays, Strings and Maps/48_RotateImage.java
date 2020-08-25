/***********************************************
Time Complexity : O(n^2)
Space Complexity : O(1)
https://leetcode.com/problems/rotate-image/
***********************************************/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose matrix: swap(array[i][j], array[j][i])
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
         // Step 2: Flip horizontally: swap(array[i][j], array[i][n - 1 -j])
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}