class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num : nums){
            hashSet.add(num);
        }
        int maxLength = 0;
        int currLength = 1;
        for(int num: hashSet){
            int currValue = num;
            if(!hashSet.contains(currValue+1)){
                while(hashSet.contains(currValue-1)){
                currLength++;
                currValue--;
            }
            maxLength = Math.max(currLength,maxLength);
            currLength = 1;
            }
        }
        return maxLength;
    }
}