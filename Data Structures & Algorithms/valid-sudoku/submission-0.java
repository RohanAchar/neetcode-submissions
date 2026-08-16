/*
Approach:
- rowSets: row number -> values already seen in that row
- colSets: column number -> values already seen in that column
- squares: square ID -> values already seen in that 3x3 square
For each non-empty cell:
1. Find square ID: (i / 3) * 3 + (j / 3)
2. Check its row, column, and square sets.
3. If value exists in any set, return false; otherwise add it to all three.

computeIfAbsent:
Set<Integer> rowSet = rowSets.computeIfAbsent(i, key -> new HashSet<>());
- If key i exists, returns its existing HashSet.
- If missing, creates, stores, and returns a new HashSet.
Equivalent steps:
rowSets.putIfAbsent(i, new HashSet<>());
Set<Integer> rowSet = rowSets.get(i);

Lambda:
key -> new HashSet<>()
Conceptually:
Set<Integer> createSet(Integer key) {
    return new HashSet<>();
}
The key is unused because this function always creates an empty HashSet.
Time: O(81), Space: O(81) — both O(1) for fixed 9x9 Sudoku.
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Integer>> rowSets = new HashMap<>();
        Map<Integer,Set<Integer>> colSets = new HashMap<>();
        Map<Integer,Set<Integer>> squares = new HashMap<>();
        int row = board.length;
        int col = board[0].length;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                int val = board[i][j];
                if(val == '.') continue;
                int squareId = (i/3)*3 + (j/3);
                Set<Integer> rowSet = rowSets.computeIfAbsent(i, key -> new HashSet<>());
                Set<Integer> colSet = colSets.computeIfAbsent(j, key -> new HashSet<>());
                Set<Integer> squareSet = squares.computeIfAbsent(squareId, key -> new HashSet<>());
                if(rowSet.contains(val) || colSet.contains(val) || squareSet.contains(val)) return false;
                rowSet.add(val);
                colSet.add(val);
                squareSet.add(val);
            }
        }
        return true;
    }
}