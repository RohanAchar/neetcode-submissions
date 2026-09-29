class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int m = 0;
        while(i<=j){
            m = (i+j)/2;
            if(target<nums[m]){
                j=m-1;
            }
            else if(target>nums[m]){
                i=m+1;
            }
            else{
                return m;
            }
        }
        return -1;
    }
}