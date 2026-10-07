class Solution {
    //SOLVE AGAIN
    /*
     * Compare every word with every other word.
     * If another word contains the current word, add the current word
     * to the answer and stop checking it further.
     *
     * Time: O(n² * L), where L is the string-search cost
     * Space: O(1), excluding the returned list
     */
    public List<String> stringMatching(String[] words) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }

        return answer;
    }
}