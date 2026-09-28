class Solution {
    // Explaination by chatgpt
    /*
    Use a monotonic increasing stack that stores pairs of:

    [startIndex, height]

    Each bar in the stack can extend left until its stored startIndex. When the
    current height is smaller than the height at the back of the stack, the taller
    bar can no longer extend to the right.

    Pop that taller bar and calculate its maximum possible area:

    (currentIndex - storedStartIndex) * storedHeight

    The current shorter bar can extend back to the popped bar's startIndex, so
    update start to that index. Continue popping while the current height is
    smaller than the stack's last height.

    After processing all bars, any bars remaining in the stack can extend until
    the end of the histogram. Calculate their areas using:

    (n - storedStartIndex) * storedHeight

    The stack is monotonic increasing by height. Each bar is pushed and popped at
    most once, so the time complexity is O(n) and the space complexity is O(n).
    */

    // Own explaination
    // use stack (index,height). store increasing height. if lesser height found pop head, find max
    // area this head's height would have given and update maxArea, update start of present height
    // to head's index because the present height as its less it can extend backwards to the head's
    // index. offer this updated start and current height to stack and continue. Once all done some
    // remain in stack that means that height remained valid till end so calculate its area by
    // (len(heights)-its index)*(its height). Return max area.
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> st = new ArrayDeque<>();
        int n = heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int start = i;
            while (!st.isEmpty() && st.peekLast()[1] > heights[i]) {
                int[] curr = st.pollLast();
                int index = curr[0];
                int height = curr[1];
                maxArea = Math.max(maxArea, (i - index) * height);
                start = index;
            }
            st.offerLast(new int[] {start, heights[i]});
        }
        while (!st.isEmpty()) {
            int[] curr = st.pollLast();
            int index = curr[0];
            int height = curr[1];
            maxArea = Math.max(maxArea, (n - index) * height);
        }
        return maxArea;
    }
}