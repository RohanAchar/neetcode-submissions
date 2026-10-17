class Solution {
    //SOLVE AGAIN
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            // Add a new 1 at the end of the current row
            row.add(1);
            
            // Update the inner elements from right to left
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }
        
        return row;
    }
}