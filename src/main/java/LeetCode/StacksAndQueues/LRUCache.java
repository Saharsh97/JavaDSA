package LeetCode.StacksAndQueues;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    class Node{
        Integer key;
        Integer value;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        pushEntryToRightSide(key);
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if(!cache.containsKey(key)){
            cache.put(key, new Node(key, value));
        }
        Node entry = cache.get(key);
        entry.value = value;

        pushEntryToRightSide(key);

        if(cache.size() > capacity){
            Map.Entry<Integer, Node> lruEntry = cache.entrySet().stream().findFirst().get();
            cache.remove(lruEntry.getKey());
        }
    }

    private void pushEntryToRightSide(int key){
        Node entry = cache.get(key);
        cache.remove(entry.key);
        cache.put(entry.key, entry);
    }
}
