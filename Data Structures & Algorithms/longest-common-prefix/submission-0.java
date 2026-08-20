/*
Approach:
Use the first string as the reference. For each character index in the first
string, check whether every string has a character at that index and whether
it matches the reference character.

- If any string ends at the current index, the common prefix cannot become
  longer, so return the prefix built so far.
- If any character does not match the reference character, return the prefix
  built so far, because characters after that position cannot be part of a
  common prefix.
- If every string has the same character at the current index, append it to ans.

After checking all characters of the first string, return ans.

Time: O(n × m), where n is the number of strings and m is the length of the
shortest string / longest possible common prefix.
Space: O(m) for StringBuilder ans.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<strs[0].length();i++){
            for(String str : strs){
                if(str.length()==i || str.charAt(i)!=strs[0].charAt(i)) return ans.toString();
            }
            ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
}