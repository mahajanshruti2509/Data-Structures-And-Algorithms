/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/subarray-sum-equals-k/
***********************************************/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currSum = 0;
        Map<Integer,Integer> prefixSum = new HashMap<Integer, Integer>();
        prefixSum.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];
            if(prefixSum.containsKey(currSum-k)){
                count += prefixSum.get(currSum-k);
            }
            prefixSum.put(currSum, prefixSum.getOrDefault(currSum, 0) + 1);
        } 
        return count;
    }
}