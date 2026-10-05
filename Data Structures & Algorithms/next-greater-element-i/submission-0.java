class Solution {
    /*
     * Traverse nums2 using a monotonic decreasing stack.
     *
     * The stack stores values whose next greater element has not been found yet.
     * When the current number is greater than the stack top, it is the next
     * greater element for that top value. Keep popping and store:
     * smallerValue -> currentGreaterValue in a map.
     *
     * Then build the answer for nums1 using the map. If a value is absent from
     * the map, it has no greater value to its right, so return -1.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peekLast() < num) {
                nextGreater.put(stack.pollLast(), num);
            }

            stack.offerLast(num);
        }

        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            answer[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return answer;
    }
}