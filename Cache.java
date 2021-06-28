package cache;

import cache.Storage.Storage;
import cache.policies.EvictionPolicy;

public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;
    int capacity;

    Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            storage.add(key, value);
            evictionPolicy.keyAccessed(key);
        } catch (Exception StorageFullException) {
            System.out.println("Full Storage");
            Key keyToRemove = evictionPolicy.evictKey();
            this.storage.remove(keyToRemove);
            put(key, value);
        }
    }

    public Value get(Key key) {
        try {
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (Exception NotFoundException) {
            System.out.println("Key Not found");
            return null;
        }
    }

    public void printCache(){
        evictionPolicy.printCache();
    }
}