//package LeetCode.StacksAndQueues;
//
//import java.util.*;
//
//public class LFUCache {
//    class Node{
//        Integer key;
//        Integer value;
//        Integer counter;
//
//        public Node(Integer key, Integer value, Integer counter) {
//            this.key = key;
//            this.value = value;
//            this.counter = counter;
//        }
//    }
//
//    int capacity;
//    Map<Integer, Node> cache;
//    Map<Integer, LinkedHashMap<Integer, Node>> counterMap;
//
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        cache = new HashMap<>();
//        counterMap = new TreeMap<>();
//        counterMap.put(1, new LinkedHashMap<>());
//    }
//
//    public int get(int key) {
//        if(!cache.containsKey(key)){
//            return -1;
//        }
//        Node node = cache.get(key);
//        int previousCount = node.counter;
//        int newCount = previousCount+1;
//        node.counter = newCount;
//
//        removeNodeFromCounterMap(previousCount, key);
//        addNodeToCounterMap(newCount, key, node);
//        cache.put(key, node);
//        return node.value;
//    }
//
//    public void put(int key, int value) {
//        if(!cache.containsKey(key)){
//            if(cache.size() == capacity){
//                Map.Entry<Integer, LinkedHashMap<Integer, Node>> leastCounterEntry = counterMap.entrySet().stream().findFirst().get();
//                Map.Entry<Integer, Node> firstEntryInList = leastCounterEntry.getValue().firstEntry();
//                leastCounterEntry.getValue().remove(firstEntryInList.getKey());
//
//                cache.remove(firstEntryInList.getKey());
//            }
//
//            Node newNode = new Node(key, value, 1);
//            cache.put(key, newNode);
//            addNodeToCounterMap(1, key, newNode);
//        } else {
//            get(key);
//            cache.get(key).value = value;
//        }
//    }
//
//    private void addNodeToCounterMap(int count, int key, Node node){
//        if(!counterMap.containsKey(count)){
//            counterMap.put(count, new LinkedHashMap<>());
//        }
//        counterMap.get(count).put(key, node);
//    }
//
//    private void removeNodeFromCounterMap(int count, int key){
//        counterMap.get(count).remove(key);
//        if(counterMap.get(count).isEmpty()){
//            counterMap.remove(count);
//        }
//    }
//}
