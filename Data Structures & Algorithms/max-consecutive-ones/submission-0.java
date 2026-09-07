class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currSum = 0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==1){
                currSum+=1;
                max = Math.max(max,currSum);
            }
            else{
                currSum=0;
            }
        }
        return max;
    }
}