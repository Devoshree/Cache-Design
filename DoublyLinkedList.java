package cache.datastructures;

public class DoublyLinkedList<E> {
    DLLNode<E> first;
    DLLNode<E> last;

    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }

    public void detachNode(DLLNode<E> node) {
        if(node == null)
            return;
        if(node.equals(first)){
            first = first.next;
            if(first != null){
                first.prev = null;
            }
        }
        else if(node.equals(last)){
            last = last.prev;
            if(last.next != null)
                last.next = null;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

    }

    public void addNodeAtLast(DLLNode<E> node) {
        if(last == null){
            last = node;
            first = node;
        }
        else {
            last.next = node;
            node.prev = last;
            node.next = null;
            last = node;
        }

    }

    public DLLNode<E> addElementAtLast(E element) {
        DLLNode<E> newNode = new DLLNode<>(element);
        addNodeAtLast(newNode);
        return newNode;
    }

    public DLLNode<E> getFirst() {
        return first;
    }
}
