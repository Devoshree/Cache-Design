package cache.Storage;

public interface Storage<Key, Value> {

    void add(Key key, Value value);

    void remove(Key keyToRemove);

    Value get(Key key);

}
