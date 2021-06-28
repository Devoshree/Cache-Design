package cache;

import cache.Storage.HashMapBasedStorage;
import cache.policies.LRUEvictionPolicy;

public class Driver {

    /*
    * Cache should support following operations:
    * Put: This will allow user to put value against a key
    * Get: This will allow user to access previously saved value using key
    * Eviction Policy: Cache should also support removal of some key, when full and we try to add new key-value pair.
    * */
    public static void main(String[] args) {
        Cache cache = new Cache(new LRUEvictionPolicy<Integer>(), new HashMapBasedStorage<Integer, Integer>(3));
        cache.put(1, 7);
        cache.put(2, 5);
        cache.put(3, 9);
        cache.printCache();
        System.out.println(cache.get(2));
        cache.printCache();
        cache.put(8, 11);
        cache.printCache();
        cache.get(9);
        cache.printCache();


    }
}
