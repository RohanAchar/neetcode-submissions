class MyHashSet {
    //SOLVE AGAIN
    private final int BUCKET_SIZE = 769;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BUCKET_SIZE;
    }
    
    public void add(int key) {
        int bucketIndex = hash(key);
        // Only add if it doesn't already exist
        if (!buckets[bucketIndex].contains(key)) {
            buckets[bucketIndex].add(key);
        }
    }
    
    public void remove(int key) {
        int bucketIndex = hash(key);
        // Remove the object wrapper to ensure value removal instead of index removal
        buckets[bucketIndex].remove(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_true = obj.contains(key);
 */