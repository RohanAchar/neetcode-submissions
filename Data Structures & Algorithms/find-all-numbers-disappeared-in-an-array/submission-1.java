class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
        Since every value is in the range [1, n], each value v maps to index v - 1.

        Traverse the array once. For each value, use Math.abs(nums[i]) because that
        value may already have been marked negative. Go to its corresponding index
        (value - 1) and make nums[value - 1] negative. A negative value indicates that
        the number value exists in the array. If it is already negative, that number is
        a duplicate, so no further action is needed.

        After the first traversal, every number that appears in nums has marked its
        corresponding index as negative. Traverse the array again: if nums[i] is still
        positive, then i + 1 never appeared in the input, so add i + 1 to the answer.

        This works because the constraints guarantee that all original values are
        between 1 and n. Note that this approach modifies the input array.
        */
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])-1]>0) nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
//Below is with chatgpt which made code more readable
// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> missingNumbers = new ArrayList<>();

//         for (int num : nums) {
//             int index = Math.abs(num) - 1;

//             if (nums[index] > 0) {
//                 nums[index] = -nums[index];
//             }
//         }

//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] > 0) {
//                 missingNumbers.add(i + 1);
//             }
//         }

//         return missingNumbers;
//     }
// }