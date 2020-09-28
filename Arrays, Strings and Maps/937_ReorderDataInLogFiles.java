/***********************************************
Let n be the number of logs in the list and m be the maximum length of a single log.
Time Complexity : O(m n log n)
Space Complexity : O(m log n)
https://leetcode.com/problems/reorder-data-in-log-files/
***********************************************/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] log1Split = log1.split(" ", 2);
            String[] log2Split = log2.split(" ", 2);
            
            boolean isLog1DigitLog = Character.isDigit(log1Split[1].charAt(0));
            boolean isLog2DigitLog = Character.isDigit(log2Split[1].charAt(0));
            
            if(!isLog1DigitLog && !isLog2DigitLog) { // both letter logs
                int comparison = log1Split[1].compareTo(log2Split[1]);
                if(comparison == 0) {
                    // contents of both letter logs are same. So compare the identfiers
                    return log1Split[0].compareTo(log2Split[0]);
                }
                return comparison;
            }
            
            if(isLog1DigitLog) {
                if(isLog2DigitLog) {
                    return 0; // Treat both digit logs as equal
                }
                return 1; // log2 is letter log. 
            } else {
                // log1 is letter and log2 is digit
                return -1;
            }
            
        });
        return logs;
    }
}