class Solution {
    /*
    Track whether the array can be non-decreasing and/or non-increasing.
    If both possibilities become false, the array is not monotonic.
    
    Time: O(n)
    Space: O(1)
    */
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean increasing = true;
        boolean decreasing = true;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]) increasing = false;
            if(nums[i]<nums[i+1]) decreasing = false;
            if(!increasing && !decreasing) return false;
        }
        return true;
        // int n = nums.length;
        // int order = -1;
        // if(n<2) return true;
        // int l = nums[0];
        // int r = nums[n-1];
        // if(l<=r) order = 1;
        // if(order==1){
        //     for(int i=0;i<n-1;i++){
        //         l=nums[i];
        //         r=nums[i+1];
        //         if(l>r) return false;
        //     }
        // }
        // else if(order==-1){
        //     for(int i=0;i<n-1;i++){
        //         l=nums[i];
        //         r=nums[i+1];
        //         if(l<r) return false;
        //     }
        // }
        // return true;
    }
}