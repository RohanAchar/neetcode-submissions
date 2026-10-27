public class Solution {
    //SOLVE AGAIN
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If the number of characters doesn't match the number of words, return false
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            // Check if the character is already mapped to a different word
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(w)) {
                return false;
            }
            
            // Check if the word is already mapped to a different character
            if (wordToChar.containsKey(w) && wordToChar.get(w) != c) {
                return false;
            }
            
            // Establish the mapping
            charToWord.put(c, w);
            wordToChar.put(w, c);
        }
        
        return true;
    }
}