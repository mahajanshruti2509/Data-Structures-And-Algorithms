/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/single-number-iii/
***********************************************/

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] output = new int[2];
        if(nums.length == 0 || nums == null) {
            return output;
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                output[index] = entry.getKey();
                index++;
            }
        }
        return output;
    }
}