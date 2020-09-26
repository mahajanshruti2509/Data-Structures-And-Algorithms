/***********************************************
Time Complexity : O(n)
Space Complexity : O(n)
https://leetcode.com/problems/verifying-an-alien-dictionary/
***********************************************/

class Solution {
    
    public int[] char_map;
    
    public boolean isAlienSorted(String[] words, String order) {
        char_map = new int[26];
        for(int i = 0; i < order.length(); i++) {
          char_map[order.charAt(i) - 'a'] = i;
        }

        for(int i = 1; i < words.length; i++) {
          if(compare(words[i-1], words[i]) > 0) {
            return false;
          }
        }
        return true;
    }
    
    private int compare(String word1, String word2) {
    int i = 0;
    int j = 0;
    int char_compare_val = 0;

    while(i < word1.length() && j < word2.length() && char_compare_val == 0) {
      // Continue until characters in both words are same
      char_compare_val = char_map[word1.charAt(i) - 'a'] - char_map[word2.charAt(i) - 'a'];
      i++;
      j++;
    }

    /* Characters in both the words are same but we might exit out of the while loop because both strings are not of same     length:
    1) word1 length < word2 length, ex: hel , hello then this returns a negative number which is valid
    2) word2 length > word1 length, ex: hello, hel then this returns a positive number which is not valid
    */
    if(char_compare_val == 0) {
      return word1.length() - word2.length();
    } else {
      return char_compare_val;
    }
  }
}