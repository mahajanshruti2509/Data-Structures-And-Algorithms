/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/maximum-subarray/
***********************************************/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
        
        for(int i = 1 ; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}