class Solution {
    public boolean divideArray(int[] nums) {
        /*
         * Approach: Frequency Array Counting
         * Since the problem constraints state that element values fall within 
         * the range [1, 500], we use a fixed-size integer array instead of a 
         * HashMap. We count the occurrences of each number, and then verify 
         * that every frequency is an even number (meaning all elements can 
         * be successfully split into pairs).
         * 
         * Time Complexity: O(N) 
         *   - Where N is the length of the array 'nums'. We iterate through 
         *     'nums' once to populate frequencies, and then loop through a 
         *     fixed-size array of size 501, which takes O(1) constant time.
         * 
         * Space Complexity: O(1) (Auxiliary Space)
         *   - The frequency array requires a fixed size of 501 regardless of 
         *     the size of the input array, avoiding the memory overhead of objects 
         *     and boxing associated with a HashMap.
         */
        int[] freq = new int[501];
        for(int num : nums){
            freq[num] = freq[num] + 1;
        }
        for(int f : freq){
            if(f % 2 != 0) return false;
        }
        return true;
        
        // Previous Map-based approach (kept for reference):
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int num : nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }
        // for(int val : map.values()){
        //     if(val%2!=0) return false;
        // }
        // return true;
    }
}