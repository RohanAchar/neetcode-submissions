class Solution {
    public int maxNumberOfBalloons(String text) {
        //SOLVE AGAIN
        // Frequency array to store counts for a-z
        int[] counts = new int[26];
        
        // Count each character in the text
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        
        // Extract the counts for the required letters
        int b = counts['b' - 'a'];
        int a = counts['a' - 'a'];
        int l = counts['l' - 'a'] / 2; // 'l' appears twice in "balloon"
        int o = counts['o' - 'a'] / 2; // 'o' appears twice in "balloon"
        int n = counts['n' - 'a'];
        
        // The maximum number of "balloon" instances is limited by the minimum count
        int min = Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
        
        return min;
    }
}