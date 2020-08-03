/***********************************************
Time Complexity : O(n3)
Space Complexity : O(1)
https://leetcode.com/problems/count-good-triplets/
***********************************************/

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        // Fix the first element as A[i]
        for (int i = 0; i < arr.length-2; i++) {
            // Fix the second element as A[j]
            for (int j = i+1; j < arr.length-1; j++) {
                // Now look for the third number
                for (int k = j+1; k < arr.length; k++) {
                    boolean condition1 = Math.abs(arr[i] - arr[j]) <= a;
                    boolean condition2 = Math.abs(arr[j] - arr[k]) <= b;
                    boolean condition3 = Math.abs(arr[i] - arr[k]) <= c;
                    if(condition1 && condition2 && condition3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}