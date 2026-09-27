class Solution {
    // Rephrased explaination using chatgpt
    /*
    The deque stores indices from the current sliding window. Their corresponding
    values in nums are maintained in decreasing order from front to back.

    Therefore, the front of the deque always contains the index of the maximum
    value for the current window.

    For every right pointer r:
    1. Remove indices from the back while nums[index] is smaller than nums[r].
    Those values can never become the maximum in the current or any future
    window because nums[r] is greater and will remain in the window longer.
    2. Add r to the back of the deque.
    3. Remove the front index if it is smaller than l, because it is outside the
    current window.
    4. Once the window reaches size k, nums[q.peekFirst()] is the maximum value
    of that window, so add it to the answer.
    5. Move l forward to prepare for the next window.

    Each index is added once and removed at most once, so the time complexity is
    O(n). The deque can hold at most k indices, so the auxiliary space is O(k).
    */

    // Own explaination
    // You have a deque which stores the indices of the present window where the values of these
    // indices is in decreasing order. So for each window the largest value will be in the front of
    // this deque which you will include in your answer for that window. r is the present index of
    // your traversal, and l is the present window's start index. Now each time you come to the
    // nums[r] you will add this to the deque, but before adding you will compare nums[r] to the
    // last value in the deque (basically the value of deque is an index, so you get the value
    // present at this index and compare with nums[r], and until the last value of the deque whoese
    // value is less than the present value you remove it). Now you add the r that is the present
    // value's index to the last of the deque. Now check the index at the start of the deque is its
    // outside of present window, i.e less that l, that means the present window's start l has moved
    // forward and the first index of deque is left behind , i.e its outside of the window so you
    // remove that index from the start of the deque i.e, pollFirst so that the deque has the
    // indexes which is within the window. Next the if condition of (r+1)>=k is an edge case because
    // at the start if r<k that means we didnt reach window before including the value which is
    // largest in the ans array, thats why we have that condition. Now adding value to ans arr for
    // each window is basically the first index of deque because deque is having the indices whose
    // values are in decreasing order, i.e, peekFirst(). and you do l++ to indicate we can move to
    // next window. and r++ as well so that we move to next index. After the whole traversal of the
    // arr which is r reaching last of arr we return ans.
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.pollLast();
            }
            q.offerLast(r);
            if (q.peekFirst() < l) {
                q.pollFirst();
            }
            if (r + 1 >= k) {
                ans[j] = nums[q.peekFirst()];
                j++;
                l++;
            }
            r++;
        }
        return ans;
    }
}