class Solution {
    public int maxProductDifference(int[] nums) {
        //Time O(n) Space O(1)
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int num : nums){
            if(num>max1){
                max2 = max1;
                max1 = num;
            }
            else if(num>max2){
                max2 = num;
            }
            if(num<min1){
                min2 = min1;
                min1 = num;
            }
            else if(num<min2){
                min2 = num;
            }
        }
        return (max1*max2)-(min1*min2);

        //Time O(nlogn) Space O(1)
        // Arrays.sort(nums);
        // int length = nums.length;
        // int w = nums[0];
        // int x = nums[1];
        // int y = nums[length-2];
        // int z = nums[length-1];
        // int l = 1;
        // int r = length-2;
        // return Math.abs((w*x)-(y*z));
    }
}