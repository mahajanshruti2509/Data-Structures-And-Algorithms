/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/container-with-most-water/
***********************************************/

class Solution {
    public int maxArea(int[] height) {
        // Two pointer technique
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int currentArea =  minHeight * width;
            maxArea = Math.max(maxArea, currentArea);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}