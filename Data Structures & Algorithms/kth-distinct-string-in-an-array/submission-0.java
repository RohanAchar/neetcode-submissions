class Solution {
    public String kthDistinct(String[] arr, int k) {
        //SOLVE AGAIN
        // Step 1: Count frequencies of each string
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        
        // Step 2: Find the k-th distinct string in order of appearance
        int distinctCount = 0;
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                distinctCount++;
                if (distinctCount == k) {
                    return s;
                }
            }
        }
        
        // Return empty string if fewer than k distinct strings exist
        return "";
    }
}