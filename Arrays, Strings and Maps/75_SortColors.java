/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/sort-colors/
https://www.youtube.com/watch?v=sEQk8xgjx64
***********************************************/

class Solution {
    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return;
        }
        
        int low = 0;
        int medium = 0;
        int high = nums.length - 1;
        int temp;
        
        while(medium <= high) {
            if(nums[medium] == 0) {
                temp = nums[low];
                nums[low] = nums[medium];
                nums[medium] = temp;
                low++;
                medium++;
            } else if(nums[medium] == 2) {
                temp = nums[medium];
                nums[medium] = nums[high];
                nums[high] = temp;
                high--;
            } else {
                // If nums[medium] == 1, simply increment the medium pointer
                medium++;
            }
        }
    }
}