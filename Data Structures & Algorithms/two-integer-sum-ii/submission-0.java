class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i<=j){
            int total = numbers[i]+numbers[j];
            if(total == target) return new int[] {i+1,j+1};
            else if(total<target) i++;
            else j--;
        }
        return new int[] {};
    }
}