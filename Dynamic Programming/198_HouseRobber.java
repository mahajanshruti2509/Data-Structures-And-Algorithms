/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/house-robber/
***********************************************/

/* A robber has 2 options: a) rob current house i; b) don't rob current house.
If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the one before previous i-2 and gets all cumulative loot that follows.
If an option "b" is selected the robber gets all the possible loot from robbery of i-1 and all the following buildings.
So it boils down to calculating what is more profitable:

robbery of current house + loot from houses before the previous
loot from the previous house robbery and any loot captured before that
rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }
        
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0]; // for house 0, we can only rob house 0
        dp[1] = Math.max(nums[0], nums[1]);  // for house 1, we can rob just house 1 or just house 0, we take the max
        int option1 = 0;
        int option2 = 0;
        
        for(int i = 2; i < nums.length; i++) {
            option1 = dp[i-2] + nums[i];
            option2 = dp[i-1];
            dp[i] = Math.max(option1, option2);
        }
        return dp[nums.length-1];
    }
}