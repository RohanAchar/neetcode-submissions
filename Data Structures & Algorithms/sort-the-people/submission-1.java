class Solution {
    // Explaination by chatgpt
    /*
    Create an array of indices from 0 to n - 1. Sort those indices using the
    corresponding values in heights in descending order. Because each index still
    points to its original person, build the answer by taking names[order[i]].
    This keeps the name-height pairing intact without modifying the input arrays.

    Time Complexity: O(n log n) because of sorting.
    Space Complexity: O(n) for the order array and answer array.
    */

    // Own explaination
    // Have an order array which has indices. Sort these indices based on heights using custom
    // comparator sort. Return names in the order of indices which is present in the order array
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] order = new Integer[names.length];
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(heights[b], heights[a]));
        for (int i = 0; i < names.length; i++) {
            ans[i] = names[order[i]];
        }
        return ans;
    }
}