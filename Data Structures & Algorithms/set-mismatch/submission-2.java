class Solution {
    public int[] findErrorNums(int[] nums) {
        //Time O(n) & Space - O(1)
        int[] ans = new int[2];
        for(int num : nums){
            int val = Math.abs(num);
            if(nums[val-1]<0) ans[0]=val;
            else{
                nums[val-1]=-nums[val-1];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) ans[1]=i+1;
        }
        return ans;

        //Time - O(n) & Space - O(n)
        // Set<Number> set = new HashSet<>();
        // int[] ans = new int[2];
        // for(int num : nums){
        //     if(set.contains(num)) ans[0]=num;
        //     else {
        //         set.add(num);
        //     }
        // }
        // for(int i = 1;i<=nums.length;i++){
        //     if(!set.contains(i)){
        //         ans[1]=i;
        //     }
        // }
        // return ans;
    }
}