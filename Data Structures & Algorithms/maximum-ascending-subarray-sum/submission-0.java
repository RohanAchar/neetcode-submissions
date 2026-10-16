class Solution {
    public int maxAscendingSum(int[] nums) {
        // Time Complexity: O(N) - We traverse the array of length N exactly once.
        // Space Complexity: O(1) - Only a constant amount of extra memory is used.
        
        int n = nums.length;
        int ans = nums[0]; // Tracks the maximum ascending subarray sum found so far
        int sum = nums[0]; // Tracks the sum of the current strictly increasing subarray
        
        for(int i = 1; i < n; i++) {
            // If strictly increasing, extend the current sum; otherwise, reset sum to the current element
            sum = (nums[i-1] < nums[i]) ? sum + nums[i] : nums[i];
            
            // Update the global maximum sum
            ans = Math.max(sum, ans);
        }
        
        return ans;
    }
}