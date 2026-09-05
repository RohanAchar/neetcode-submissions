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