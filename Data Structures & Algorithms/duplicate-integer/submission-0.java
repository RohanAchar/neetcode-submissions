class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            if(!hashSet.contains(num)){
                hashSet.add(num);
            }
            else{
                return true;
            }
        }
        return false;
    }
}