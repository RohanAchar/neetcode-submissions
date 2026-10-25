class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int num : nums1){
            setOne.add(num);
        }
        for(int num : nums2){
            setTwo.add(num);
        }
        for(int num : setOne){
            if(setTwo.contains(num)) ans.add(num);
        }
        int[] ans1 = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ans1[i]=ans.get(i);
        }
        return ans1;
    }
}