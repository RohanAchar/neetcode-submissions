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

// 1  3 6 10
// 10 9 7  4