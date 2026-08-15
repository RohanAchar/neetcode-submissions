/*
Idea 1: Prefix and suffix arrays — O(n) time, O(n) extra space

Create a prefix array where prefix[i] stores the product of all elements
from index 0 through i.

Create a suffix array where suffix[i] stores the product of all elements
from index i through the last index.

For each index i:
- Product of elements to its left = prefix[i - 1]
- Product of elements to its right = suffix[i + 1]
- Therefore, answer[i] = prefix[i - 1] * suffix[i + 1]

Handle the first and last elements separately because they do not have a
left or right side respectively.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int[] ans = new int[length];
        prefix[0]=nums[0];
        suffix[length-1]=nums[length-1];
        for(int i = 1;i<length;i++){
            prefix[i]=prefix[i-1]*nums[i];
        }
        for(int i = length-2;i>=0;i--){
            suffix[i]=suffix[i+1]*nums[i];
        }
        ans[0]=suffix[1];
        ans[length-1]=prefix[length-2];
        for(int i=1;i<length-1;i++){
            ans[i]=prefix[i-1]*suffix[i+1];
        }
        return ans;
    }
}
*//*
Idea 2: Use the answer array itself — O(n) time, O(1) extra space

The output array does not count as extra space.

First pass, left to right:
Store in ans[i] the product of every element to the left of i.
Use prefix to keep track of the running left-side product.

Second pass, right to left:
suffix holds the product of every element to the right of i.
Multiply ans[i] by suffix, so it now becomes the product of every element
except nums[i]. Then update suffix using nums[i].

Return ans.
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int prefix = 1;
        int suffix = 1;
        int[] ans = new int[length];
        for(int i =0;i<length;i++){
            ans[i]=prefix;
            prefix*=nums[i];
        }
        for(int i =length-1;i>=0;i--){
            ans[i]*=suffix;
            suffix*=nums[i];
        }
        return ans;
    }
}