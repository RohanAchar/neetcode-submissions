// Approach: HashMap + Min-Heap
//
// 1. Count the frequency of every number using a HashMap:
//    number -> frequency.
//
// 2. Create a min-heap (PriorityQueue). The queue stores the numbers/keys,
//    but orders them by their frequency from the HashMap.
//
//    (a, b) -> Integer.compare(hashMap.get(a), hashMap.get(b))
//    means the number with smaller frequency is at the top.
//
// 3. Loop through each unique number in hashMap.entrySet():
//    - Add the current number to the heap.
//    - If heap size becomes greater than k, poll() the top element.
//      Since this is a min-heap by frequency, poll() removes the
//      least-frequent number.
//
//    Add first, then check size. We must check after adding because the
//    current number may make the heap size exceed k. If we checked before
//    adding, the final iteration could leave k + 1 elements with no next
//    iteration to remove the extra one.
//
// 4. After processing all unique numbers, the heap contains exactly the
//    k most frequent numbers. Poll each number into the result array.
//
// Time: O(n + u log k), where u is the number of unique numbers.
// Space: O(u + k).

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] arr = new int[k];
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(hashMap.get(a), hashMap.get(b)));
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            pq.offer(entry.getKey());
            if (pq.size() > k)
                pq.poll();
        }
        for (int i = 0; i < k; i++) arr[i] = pq.poll();
        return arr;
    }
}