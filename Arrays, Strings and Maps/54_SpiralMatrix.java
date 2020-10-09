/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/spiral-matrix/
***********************************************/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if(matrix.length == 0) {
            return result;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;
        
        while(rowBegin <= rowEnd && columnBegin <= columnEnd) {
            
            // top left to top right
            for(int i = columnBegin; i <= columnEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            
            // top right to bottom right
            for(int i = rowBegin; i <=rowEnd; i++) {
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            
            // bottom right to bottom left
            if(rowBegin <= rowEnd) {
                for(int i = columnEnd; i >= columnBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            
            // remaining part
            if(columnBegin <= columnEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;
            
        }// outer while
        
        return result;
    }
}