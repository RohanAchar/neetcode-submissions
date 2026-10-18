class Solution {
    //SOLVE AGAIN
    public int countCharacters(String[] words, String chars) {
        // Step 1: Count the frequency of each character in chars
        int[] charCount = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCount[chars.charAt(i) - 'a']++;
        }
        
        int totalLength = 0;
        
        // Step 2: Check each word
        for (String word : words) {
            int[] wordCount = new int[26];
            boolean canForm = true;
            
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                wordCount[index]++;
                
                // If the word requires more characters than available in chars, it's invalid
                if (wordCount[index] > charCount[index]) {
                    canForm = false;
                    break;
                }
            }
            
            // If the word can be formed, add its length to the total
            if (canForm) {
                totalLength += word.length();
            }
        }
        
        return totalLength;
    }
}