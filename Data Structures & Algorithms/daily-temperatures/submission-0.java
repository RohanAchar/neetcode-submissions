class Solution {
    /*
    The deque stores indices of days whose next warmer temperature has not yet
    been found. The temperatures at those indices are maintained in decreasing
    order from front to back.

    For each day i, compare temperatures[i] with the temperature at the index
    stored at the back of the deque.

    If temperatures[i] is greater, then day i is the next warmer day for that
    stored index. Remove the index from the back and set:

    ans[previousIndex] = i - previousIndex

    Continue doing this while the current temperature resolves previous colder
    days. Then add i to the deque, since its next warmer day may occur later.

    Any indices remaining in the deque after the traversal do not have a future
    warmer temperature, so their answer remains 0.

    Each index is added once and removed at most once, giving O(n) time and O(n)
    space.
    */

    // Own explaination
    // We maintain a deque which has indices of the temperatures and its in decreasing order. When
    // you find a temperature which is greater than the last value of deque that means we have found
    // the greater temperature than the last value of deque , i.e, the last value deque is the index
    // of the temperature. So we poll this and for this index of ans we update the day where we got
    // the greater temperature i.e, val-i. We do this until the value of deque is not lesser than
    // the present index. So the remaining values of the deque should wait until we get a greater
    // temperature, this is the while loop. After this you offer the present index i to the deque.
    // By the end of the temperatures if values are left in the deque that means we didnt find a
    // greater temperature so that ans value remains 0.
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && temperatures[q.peekLast()] < temperatures[i]) {
                int val = q.pollLast();
                ans[val] = i - val;
            }
            q.offerLast(i);
        }
        return ans;
    }
}