class Solution {

    public int findMin(int[] nums) {

        int left = 0;

        int right = nums.length-1;

        // Keep searching while more than one index is possible.
        while(left < right){

            // Overflow-safe middle index.
            int mid = left + (right-left)/2;

            // mid is in the left sorted portion.
            // The minimum must be strictly on the right of mid.
            if(nums[mid] > nums[right]){

                left = mid+1;

            }

            else{

                // nums[mid] can be the minimum,
                // so do not discard mid.
                right = mid;

            }

        }

        // Here left == right. Only one index remains,
        // and it points to the minimum element.

        return nums[right];

    }

}