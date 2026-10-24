class Solution {
    public List<String> commonChars(String[] words) {
        //SOLVE AGAIN
        // Initialize the global minimum frequency tracker with the first word's counts
        int[] minFreq = new int[26];
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }
        
        // Update the tracker with the minimum counts from subsequent words
        for (int i = 1; i < words.length; i++) {
            int[] charCount = new int[26];
            for (char c : words[i].toCharArray()) {
                charCount[c - 'a']++;
            }
            
            // Intersect frequencies by keeping the minimum
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], charCount[j]);
            }
        }
        
        // Build the result list using the final frequencies
        List<String> result = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            while (minFreq[j] > 0) {
                result.add(String.valueOf((char) (j + 'a')));
                minFreq[j]--;
            }
        }
        
        return result;
    }
}