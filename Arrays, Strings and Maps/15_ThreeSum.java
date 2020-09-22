/****************************************************************************************************************
Time Complexity : O(n * n)
Space Complexity : from log n to O(n) depending on the implementation of the sorting algorithm. For the purpose of complexity analysis, 
we ignore the memory required for the output.
https://leetcode.com/problems/3sum/
*****************************************************************************************************************/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1]) {
                // ignores duplicates elements at the starting position
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end) {
                if(end < nums.length - 1 && nums[end] == nums[end+1]) {
                    // ignores duplicates elements at the ending position
                    end--;
                    continue;
                }
                
                if(nums[i] + nums[start] + nums[end] == 0) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[start], nums[end]);
                    result.add(triplets);
                    start++; 
                    end--;
                } else if(nums[i] + nums[start] + nums[end] < 0) { 
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}