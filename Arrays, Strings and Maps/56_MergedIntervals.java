/***********************************************
Time Complexity : O(n log n)
Space Complexity : O(n)
https://leetcode.com/problems/merge-intervals/
***********************************************/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> outputArr = new ArrayList<>();
        int[] currentInterval = intervals[0];
        outputArr.add(currentInterval);
        
        for(int[] interval : intervals) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];
            
            if(currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                outputArr.add(currentInterval);
            } 
        }
        return outputArr.toArray(new int[outputArr.size()][]);
        
    }
}