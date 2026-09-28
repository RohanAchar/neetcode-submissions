class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<int[]> st = new ArrayDeque<>();
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int start = i;
            while(!st.isEmpty() && heights[i]<st.peekLast()[1]){
                int[] curr = st.pollLast();
                int index = curr[0];
                int height = curr[1];
                maxArea = Math.max(maxArea,(i-index)*height);
                start = index;
            }
            st.offerLast(new int[]{start,heights[i]});
        }
        while(!st.isEmpty()){
            int[] curr = st.pollLast();
            int index = curr[0];
            int height = curr[1];
            maxArea = Math.max(maxArea,(n-index)*height);
        }
        return maxArea;
    }
}
