/*
Kadane’s Algorithm:

currSum represents the maximum subarray sum ending at the current index.

At every index, we have two choices:
1. Start a new subarray from nums[i].
2. Extend the previous subarray by adding nums[i] to currSum.

We choose the larger value:

currSum = Math.max(nums[i], currSum + nums[i]);

If the previous currSum is negative, adding it will reduce the current value,
so starting fresh from nums[i] is better.

maxSum stores the maximum subarray sum found anywhere so far.
After calculating currSum for every index, update maxSum if needed.

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for(int i=1;i<nums.length;i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
}