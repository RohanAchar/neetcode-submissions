class Solution {
    //SOLVE AGAIN.
    /*
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        int totalNumbers = n * n;

        int[] frequency = new int[totalNumbers + 1];

        /*
         * Count every number in the grid.
         */
        for (int[] row : grid) {
            for (int number : row) {
                frequency[number]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        /*
         * Count 2 means repeated.
         * Count 0 means missing.
         */
        for (int number = 1; number <= totalNumbers; number++) {
            if (frequency[number] == 2) {
                repeated = number;
            } else if (frequency[number] == 0) {
                missing = number;
            }
        }

        return new int[]{repeated, missing};
    }
}