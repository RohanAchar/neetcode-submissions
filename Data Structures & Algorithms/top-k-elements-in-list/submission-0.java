class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        int[] arr = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(hashMap.get(a),hashMap.get(b)));
        for(int num : nums){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            pq.offer(entry.getKey());
            if(pq.size()>k) pq.poll();
        }
        for(int i=0;i<k;i++) arr[i]=(int)pq.poll();
        return arr;
    }
}
