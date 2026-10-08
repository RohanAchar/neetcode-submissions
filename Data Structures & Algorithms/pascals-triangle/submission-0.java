class Solution {
    //SOLVE AGAIN
    /*
     * Build each row using the previous row.
     * Every row starts and ends with 1.
     * Each middle value is the sum of the two values above it.
     *
     * Time: O(numRows²)
     * Space: O(numRows²) for the returned triangle
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            currentRow.add(1);

            for (int col = 1; col < row; col++) {
                int value = result.get(row - 1).get(col - 1)
                        + result.get(row - 1).get(col);

                currentRow.add(value);
            }

            if (row > 0) {
                currentRow.add(1);
            }

            result.add(currentRow);
        }

        return result;
    }
}