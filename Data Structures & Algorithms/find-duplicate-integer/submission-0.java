/*
 * APPROACH: Floyd's Tortoise and Hare (Cycle Detection Algorithm)
 * 
 * INTUITION:
 * Treat the array as a linked list where each value acts as a pointer to the next index 
 * (nums[i] is the next node). Because there is a duplicate number, two indices point to the 
 * same value, creating a cycle.
 * 
 * PHASE 1 (Intersection):
 * Move a slow pointer by 1 step and a fast pointer by 2 steps. They are guaranteed to 
 * collide somewhere inside the cycle.
 * 
 * PHASE 2 (Cycle Entrance):
 * Reset one pointer back to the start (nums[0]) and move both pointers 1 step at a time. 
 * The point where they meet again is the entrance of the cycle—which is our duplicate number.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) — Both pointers traverse the array at most a constant number of times.
 * - Space Complexity: O(1) — Uses only a few constant integer variables, no extra data structures.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        //find if it intersects
        int s = nums[0];
        int f = nums[0];
        do {
            s = nums[s];
            f = nums[nums[f]];
        } while(s!=f);
        //find the starting point of cycle
        int s2 = nums[0];
        while(s!=s2){
            s = nums[s];
            s2 = nums[s2];
        }
        return s;
    }
}