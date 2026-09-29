class Solution {
    //Rephrased explaination
    /*
    First, binary-search the rows to find the last row whose first value is less
    than or equal to target.
    
    Because every row is sorted and the first value of each row is greater than
    the last value of the previous row, if target exists, it can only be in this
    row. If no such row exists, target is smaller than matrix[0][0], so return
    false.
    
    Next, binary-search every value in the selected row. If target is found,
    return true; otherwise, return false.
    
    Time complexity: O(log m + log n), which is O(log(m * n)).
    Space complexity: O(1).
    */
    //Own explaination
    //Do binary seach of first inidex value of each row. Once you find the row which has the closest first index which is less than target, that is the row we want because the target will surely lie in that row. Now do binary search on j,j1 that is the every value of that row. Once you get target value return true. Else return false.
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int i1 = matrix.length - 1;
        int j = 0;
        int j1 = matrix[0].length - 1;
        int m = 0;
        int n = 0;
        int row = -1;
        while (i <= i1) {
            m = i + (i1 - i) / 2;
            if (matrix[m][0] <= target) {
                row = m;
                i = m + 1;
            } else {
                i1 = m - 1;
            }
        }
        if (row == -1)
            return false;
        while (j <= j1) {
            n = j + (j1 - j) / 2;
            if (matrix[row][n] < target) {
                j = n + 1;
            } else if (matrix[row][n] > target) {
                j1 = n - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}