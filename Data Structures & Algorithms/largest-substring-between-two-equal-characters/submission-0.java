class Solution {
    //SOLVE AGAIN
    public int maxLengthBetweenEqualCharacters(String s) {
        // Array to store the first seen index of each character ('a' through 'z')
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        
        int maxLen = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a';
            
            // If we have seen this character before
            if (firstIndex[charIndex] != -1) {
                // Calculate the length of the substring between them (excluding the characters)
                int currentLen = i - firstIndex[charIndex] - 1;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                // Record the first time we encounter this character
                firstIndex[charIndex] = i;
            }
        }
        
        return maxLen;
    }
}