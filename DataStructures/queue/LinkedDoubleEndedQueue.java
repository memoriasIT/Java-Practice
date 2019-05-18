package dataStructures.queue;

public class LinkedDoubleEndedQueue<T> implements DoubleEndedQueue<T> {

    private static class Node<E> {
        private E elem;
        private Node<E> next;
        private Node<E> prev;

        public Node(E x, Node<E> nxt, Node<E> prv) {
            elem = x;
            next = nxt;
            prev = prv;
        }
    }

    private Node<T> first, last;

    /**
     *  Invariants:
     *  if queue is empty then both first and last are null
     *  if queue is non-empty:
     *      * first is a reference to first node and last is ref to last node
     *      * first.prev is null
     *      * last.next is null
     *      * rest of nodes are doubly linked
     */

    /**
     * Complexity: O(1)
     */
    public LinkedDoubleEndedQueue() {
        first = null;
        first.prev = null;

        last = null;
        last.next = null;
    }

    /**
     * Complexity: O(1)
     */
    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Complexity: O(n)
     */
    @Override
    public void addFirst(T x) {
        if (isEmpty()) {
            first = new Node<> (x, null, null);
            last  = new Node<> (x, null, null);
        } else {
            Node<T> aux = new Node<> (x, first, null);
            first = aux;
            Node<T> aux2 = last;

            while(aux2.prev != null) {
                aux2 = aux2.prev;
            }
            aux2.prev = aux;
        }
    }

    /**
     * Complexity: O(n)
     */
    @Override
    public void addLast(T x) {
        if (isEmpty()) {
            first = new Node<> (x, null, null);
            last = new Node<> (x, null, null);
        } else {
            Node<T> aux = new Node<> (x, null, last);
            last = aux;
            Node<T> aux2 = first;
            while (aux2.next != null){
                aux2 = aux2.next;
            }
            aux2.next = aux;
        }
    }


    /**
     * Complexity: O(1)
     */
    @Override
    public T first() {
        return first.elem;
    }

    /**
     * Complexity: O(1)
     */
    @Override
    public T last() {
        return last.elem;
    }

    /**
     * Complexity: O(1)
     */
    @Override
    public void deleteFirst() {
        if(first.next == null){
            first = null;
            last = null;
        } else {
            Node<T> aux = last;
            while (aux.prev.prev != null) {
                aux = aux.prev;
            }
            aux.prev = null;
            first = first.next;
        }
    }

    /**
     * Complexity: O(n)
     */
    @Override
    public void deleteLast() {
        if (first.next == null) {
            first = null;
            last = null;
        } else {
            Node<T> aux = first;
            while(aux.next.next != null){
                aux = aux.next;
            }
            aux.next = null;
            last = last.prev;
        }
    }

    /**
     * Returns representation of queue as a String.
     */
    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length()+1);
        String s = className+"(";
        for (Node<T> node = first; node != null; node = node.next)
            s += node.elem + (node.next != null ? "," : "");
        s += ")";
        return s;
    }
}

