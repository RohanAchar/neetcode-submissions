class Solution {
    //SOLVE AGAIN
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();

        // Check last word -> first word
        if (sentence.charAt(0) != sentence.charAt(n - 1)) {
            return false;
        }

        // Check every adjacent pair of words
        for (int i = 1; i < n - 1; i++) {
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }

        return true;
    }
}