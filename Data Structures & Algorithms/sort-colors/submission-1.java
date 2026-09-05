/*
Approach: Dutch National Flag algorithm.

Use three pointers:
- nz: next position where a 0 should be placed.
- i: current element being checked.
- n2: next position where a 2 should be placed.

At every step:
- All elements before nz are 0.
- All elements after n2 are 2.
- The elements from nz to i - 1 are 1.
- We still need to process elements from i to n2.

If nums[i] is 0:
Swap it with nums[nz], because 0 belongs at the beginning.
Then increment nz. It is safe to increment i because the value moved to i
comes from the already processed middle section, so it is a 1.

If nums[i] is 1:
It is already in the correct middle section, so just move i forward.

If nums[i] is 2:
Swap it with nums[n2], because 2 belongs at the end.
Then decrement n2.

Do not move i forward after handling a 2. The value that comes from nums[n2]
has not been checked yet. It could be 0, 1, or 2. For example, if it is 0,
we must process it again so it can be moved to the 0 section.

In this code, i-- is used because i++ happens at the end of every loop.
The i-- cancels that increment, keeping i at the same index for rechecking.

Time: O(n), because each element is processed at most once.
Space: O(1), because sorting happens inside the input array.
*/
class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int nz = 0;
        int n2 = nums.length-1;
        while(i<=n2){
            if(nums[i]==0){
                int temp = nums[i];
                nums[i]=nums[nz];
                nums[nz]=temp;
                nz++;
            }
            else if(nums[i]==2){
                int temp = nums[n2];
                nums[n2]=nums[i];
                nums[i]=temp;
                n2--;
                i--;
            }
            i++;
        }
    }
}