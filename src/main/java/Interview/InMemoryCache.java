package Interview;

import java.util.*;

/*

Design a In-memory Cache

cache size = 2
[1, 1, 2, 2, 3, 3, 2]

map: 1,1.  1, 2
minPQ: 1,1,

*/

// refer to Caching LLD in another code.
public class InMemoryCache {

    interface Cache{
        // String, String
        String query(String key);

        void update(String key, String value);
    }

    class LRUCache implements Cache{

        Deque<String> list;
        Map<String, String> map;
        Integer capacity;

        public LRUCache(int capacity){
            this.list = new ArrayDeque<>();
            this.map = new HashMap<>();
            this.capacity = capacity;
        }

        @Override
        public String query(String key){
            if(map.containsKey(key)){
                updateKeyToFront(key);
                return map.get(key);
            }
            return "not found";
        }

        @Override
        public void update(String key, String value){
            if(map.containsKey(key)){
                updateKeyToFront(key);
            } else {
                list.addFirst(key);
            }

            map.put(key, value);

            if(list.size() > this.capacity){
                String lastElementKey = list.getLast();
                list.removeLast();
                map.remove(lastElementKey);
            }
        }

        private void updateKeyToFront(String key){
            list.remove(key);
            list.addFirst(key);
        }
    }

    class LFUCache implements Cache{

        @Override
        public String query(String key){
            return "";
        }

        @Override
        public void update(String key, String value){

        }
    }



    public static void main(String[] args) {

        Cache cache = new InMemoryCache().new LRUCache(3);

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("give inputs");
            String input = sc.nextLine();
            String[] words = input.split(" ");

            String queryType = words[0];
            String key = words[1];
            String value;

            if(queryType.equals("update")){
                value = words[2];
                cache.update(key, value);
            } else {
                String response = cache.query(key);
                System.out.println("response is " + response);
            }
        }

    }
}
