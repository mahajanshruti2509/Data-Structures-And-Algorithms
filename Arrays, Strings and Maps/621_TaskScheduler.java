/***********************************************
Time Complexity : O(n)
Space Complexity : O(1)
https://leetcode.com/problems/task-scheduler/
https://leetcode.com/problems/task-scheduler/discuss/760131/Java-Concise-Solution-Intuition-Explained-in-Detail
***********************************************/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
			return 0;
		}
		int m = tasks.length;
		int[] charMap = new int[26];
		/* Build the count array with frequency of each task */
		for (char c : tasks) {
			charMap[c - 'A']++;
		}

		Arrays.sort(charMap);
		/* Get maximum frequency task  and calculate max idle slots*/
        int maxVal = charMap[25]-1;
		int idleSlots = maxVal * n;
		
		/* Iterate over rest of the array and reduce the idle space count */
		for (int i = 24; i >= 0; i--) {
			idleSlots -= Math.min(maxVal, charMap[i]);
		}
		/* Handle cases when idleSlots become negative */
		idleSlots = Math.max(0, idleSlots);
		return tasks.length + idleSlots;
    }
}