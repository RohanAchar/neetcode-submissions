class MyHashMap {
    
    //SOLVE AGAIN
    // Helper class to store key-value pairs
    private static class Node {
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int BUCKET_SIZE = 769;
    private LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BUCKET_SIZE;
    }
    
    public void put(int key, int value) {
        int bucketIndex = hash(key);
        LinkedList<Node> bucket = buckets[bucketIndex];
        
        // Check if the key already exists, update its value if found
        for (Node node : bucket) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        
        // Otherwise, add a new key-value node
        bucket.add(new Node(key, value));
    }
    
    public int get(int key) {
        int bucketIndex = hash(key);
        LinkedList<Node> bucket = buckets[bucketIndex];
        
        // Search for the key in the bucket
        for (Node node : bucket) {
            if (node.key == key) {
                return node.value;
            }
        }
        
        return -1; // Key not found
    }
    
    public void remove(int key) {
        int bucketIndex = hash(key);
        LinkedList<Node> bucket = buckets[bucketIndex];
        
        // Search and remove the node with the matching key
        for (Node node : bucket) {
            if (node.key == key) {
                bucket.remove(node);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_1 = obj.get(key);
 * obj.remove(key);
 */