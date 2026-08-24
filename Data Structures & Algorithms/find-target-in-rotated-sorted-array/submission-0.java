class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            // Find mid. In a rotated sorted array, at least one of
            // the two halves—[i..m] or [m..j]—is always sorted.
            int m = i + (j - i) / 2;

            int iValue = nums[i];
            int mValue = nums[m];
            int jValue = nums[j];

            if (target == mValue) {
                return m;
            }

            // First identify the sorted half.
            // We can eliminate a half only after checking whether
            // the target falls inside that sorted half's value range.
            //
            // If target is in the sorted half, search it.
            // Otherwise, target must be in the other (possibly rotated) half.

            if (iValue <= mValue) {
                // Left half [i..m] is sorted.
                if (target >= iValue && target < mValue) {
                    j = m - 1; // Target is in the sorted left half.
                } else {
                    i = m + 1; // Target must be in the right half.
                }
            } else {
                // Right half [m..j] is sorted.
                if (target > mValue && target <= jValue) {
                    i = m + 1; // Target is in the sorted right half.
                } else {
                    j = m - 1; // Target must be in the left half.
                }
            }
        }

        return -1;
    }
}