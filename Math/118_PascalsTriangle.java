/***********************************************
Time Complexity : O(n ^ 2)
Space Complexity : O(n)
https://leetcode.com/problems/pascals-triangle/
https://www.youtube.com/watch?v=7pOzP9m_bX8&feature=youtu.be
***********************************************/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) {
            return triangle;
        }
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i-1);
            List<Integer> newRow = new ArrayList<>();
            
            newRow.add(1); // first element is zero
            for(int j = 1; j < prevRow.size(); j++) {
                // Calculate the middle elements
                newRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            newRow.add(1); // last element is zero
            triangle.add(newRow);
        }
        return triangle;
    }
}