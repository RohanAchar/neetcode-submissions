class Solution {
    public boolean check(int[] nums) {
        //SOLVE AGAIN
        int n = nums.length;
        int breaks = 0;

        for (int i = 0; i < n; i++) {
            int next = nums[(i + 1) % n];
            if (nums[i] > next) {
                breaks++;
            }
            if (breaks > 1) return false;  // early exit
        }

        return true;
    }
}