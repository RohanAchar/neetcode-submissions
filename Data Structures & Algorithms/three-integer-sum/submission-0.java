class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int a = -1;
        int l = -1;
        int r = -1;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // if(i>0){
                a=nums[i];
                l=i+1;
                r=nums.length-1;
                while(l<r){
                    if(nums[l]+nums[r]>(0-a)) r--;
                    else if(nums[l]+nums[r]<(0-a)) l++;
                    else{
                        ans.add(new ArrayList<>(Arrays.asList(a,nums[l],nums[r])));
                        l++;
                        while(l<r && nums[l]==nums[l-1]){
                            l++;
                        }
                    }
                }
            // }
        }
        return ans;
    }
}