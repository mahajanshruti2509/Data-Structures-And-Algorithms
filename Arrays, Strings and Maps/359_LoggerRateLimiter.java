/***********************************************
Time Complexity : O(1). The lookup and update of the hashtable takes a constant time.
Space Complexity : O(M). M is the size of all incoming messages. Over the time, the hashtable would have an entry for each unique message that has appeared.
https://leetcode.com/problems/logger-rate-limiter/
***********************************************/

class Logger {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!map.containsKey(message)) {
            map.put(message, timestamp);;
            return true;
        } else {
            int prevTimeStamp = map.get(message);
            if(timestamp - prevTimeStamp >= 10) {
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */