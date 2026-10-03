class Solution {
    /*
    Store the distinct values from both arrays in two HashSets. A set automatically
    removes duplicates. Then traverse each set and add a number to the result only
    when it is not present in the other set.

    result[0] contains values unique to nums1.
    result[1] contains values unique to nums2.

    Time Complexity: O(n + m)
    Space Complexity: O(n + m)
    */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> setNums1 = new HashSet<>();
        Set<Integer> setNums2 = new HashSet<>();
        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums1) {
            setNums1.add(num);
        }
        for (int num : nums2) {
            setNums2.add(num);
        }
        for (int num : setNums1) {
            if (!setNums2.contains(num)) {
                result1.add(num);
            }
        }
        for (int num : setNums2) {
            if (!setNums1.contains(num)) {
                result2.add(num);
            }
        }
        result.add(result1);
        result.add(result2);
        return result;
    }
}