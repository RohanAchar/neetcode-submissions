class Solution {
    //SOLVE AGAIN
    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101]; // values are 1..100
        for (int x : nums) {
            freq[x]++;
        }

        int ans = 0;
        for (int c : freq) {
            ans += c * (c - 1) / 2;  // number of good pairs for this value
        }
        return ans;
    }
}