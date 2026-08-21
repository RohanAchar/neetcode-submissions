/*
 * k represents the index where the next unique element should be placed.
 * For each element, if it differs from the previously stored unique element,
 * copy it to nums[k] and increment k.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1;
        int length = nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]!=nums[k-1]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}