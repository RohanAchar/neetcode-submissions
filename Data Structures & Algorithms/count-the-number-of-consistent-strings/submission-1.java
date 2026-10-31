class Solution {
    //SOLVE AGAIN
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedMap = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allowedMap[c - 'a'] = true;
        }

        int count = 0;
        for (String word : words) {
            boolean ok = true;
            for (char c : word.toCharArray()) {
                if (!allowedMap[c - 'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        return count;
    }
}