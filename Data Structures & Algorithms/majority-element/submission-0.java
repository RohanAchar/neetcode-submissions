class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> hashmap = new HashMap<>();
        int n = nums.length/2;
        for(int num : nums){
            hashmap.put(num,hashmap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e: hashmap.entrySet()){
            if(e.getValue()>n) return e.getKey();
        }
        return -1;
    }
}