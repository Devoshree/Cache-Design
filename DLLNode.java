package cache.datastructures;

public class DLLNode<E> {
    E element;
    DLLNode<E> next;
    DLLNode<E> prev;

    DLLNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return this.element;
    }

    public DLLNode<E> getNext() {
        return next;
    }
}

