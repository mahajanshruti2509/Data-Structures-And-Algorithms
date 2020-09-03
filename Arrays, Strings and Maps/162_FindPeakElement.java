/***********************************************
Time Complexity : O(log n)
Space Complexity : O(1)
https://leetcode.com/problems/find-peak-element/
https://www.youtube.com/watch?v=CFgUQUL7j_c
***********************************************/

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
       }
        return left;
    }
}