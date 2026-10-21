class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        while(top<bottom && left<right){
            //add top row elements left to right
            for(int i=left;i<right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //add right elements top to bottom
            for(int i=top;i<bottom;i++){
                ans.add(matrix[i][right-1]);
            }
            right--;
            //if top crosses bottom and left crosses right then you are done and break.
            if(!(top<bottom && left<right)){
                break;
            }
            //add bottom elements right to left
            for(int i=right-1;i>=left;i--){
                ans.add(matrix[bottom-1][i]);
            }
            bottom--;
            //add left elements bottom to top
            for(int i=bottom-1;i>=top;i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}