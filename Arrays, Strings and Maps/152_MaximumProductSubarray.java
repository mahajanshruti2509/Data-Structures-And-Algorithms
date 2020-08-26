/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/maximum-product-subarray/
***********************************************/

class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            max_so_far = temp_max;
            result = Math.max(result, max_so_far);
        }
        
        return result;
    }
}