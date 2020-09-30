/***********************************************
Let n be the number of logs in the list.
Time Complexity : O(n log n)
Space Complexity : O(n log n)
https://leetcode.com/problems/reorder-data-in-log-files/
***********************************************/

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>() {
            
            @Override
            public int compare(String log1, String log2) {
                // Split each log into 2 parts: <identifier, content>
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                // Case 1) Both logs are letter-logs
                if(!isDigit1 && !isDigit2) {
                    // First compare the content
                    int comp = split1[1].compareTo(split2[1]);
                    if(comp != 0) {
                        return comp; // Content is not same
                    }
                    // Same content, hence compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }
                
                // Case 2) One of the logs is digit logs
                if(!isDigit1 && isDigit2) {
                    // Letter log comes first
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    // Case 3) Both are digit logs
                    return 0;
                }
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}