/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/find-all-duplicates-in-an-array/
***********************************************/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                result.add(nums[i]);
                i++; // skips to the next element
            }
        }
        return result;
    }
}