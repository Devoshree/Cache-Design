package cache.policies;

import cache.datastructures.DLLNode;
import cache.datastructures.DoublyLinkedList;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {
    private final DoublyLinkedList<Key> dll;
    private final Map<Key, DLLNode<Key>> mapper;

    public LRUEvictionPolicy(){
        this.dll = new DoublyLinkedList<>();
        this.mapper = new ConcurrentHashMap<>();
    }

    @Override
    public void keyAccessed(Key key)  {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        }
        else{
            DLLNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DLLNode<Key> first = dll.getFirst();
        if(first == null){
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }

    public void printCache() {
        DLLNode curr = dll.getFirst();
        while (curr != null) {
            System.out.print(curr.getElement() + " -> ");
            curr = curr.getNext();
        }
        System.out.println();
    }

}
