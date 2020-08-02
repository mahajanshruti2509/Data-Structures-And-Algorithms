/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
***********************************************/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int diff = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1]) {
                diff = diff + prices[i] - prices[i-1];
            }
        }
        return diff;
    }
}