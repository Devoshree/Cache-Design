package cache.Storage;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{
    Map<Key, Value> hm;
    int capacity;
    public HashMapBasedStorage(int capacity){
        hm = new ConcurrentHashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(hm.size() == this.capacity)
            throw new StorageFullException();
        hm.put(key, value);
    }

    @Override
    public void remove(Key keyToRemove) throws NotFoundException {
        hm.remove(keyToRemove);
    }

    @Override
    public Value get(Key key) throws NotFoundException{
        if(!hm.containsKey(key))
            throw new NotFoundException();
        return hm.get(key);
    }
}
