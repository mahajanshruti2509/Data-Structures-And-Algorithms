/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/two-sum/
***********************************************/

import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] output = new int[2];
    if(nums == null || nums.length == 0) {
      return output;
    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int complement = 0;

    for(int i = 0; i < nums.length; i++) {
      complement = target - nums[i];
      if(map.containsKey(complement)) {
        output[0] = map.get(complement);
        output[1] = i;
        return output;
      }
      map.put(nums[i], i);
    }
    return output;
  }
}