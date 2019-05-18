package dataStructures.PriorityQueue;
//     ___      _            _ _           ____
//    / _ \_ __(_) ___  _ __(_) |_ _   _  /___ \_   _  ___ _   _  ___
//   / /_)/ '__| |/ _ \| '__| | __| | | |//  / / | | |/ _ \ | | |/ _ \
//  / ___/| |  | | (_) | |  | | |_| |_| / \_/ /| |_| |  __/ |_| |  __/
//  \/    |_|  |_|\___/|_|  |_|\__|\__, \___,_\ \__,_|\___|\__,_|\___|
//  Memorias de un informático     |___/

public class LinkedPriorityQueue<T extends Comparable<? super T>> implements dataStructures.PriorityQueue.PriorityQueue<T> {
    // Node for linked Structure
    static private class Node<E> {
        E elem;
        Node<E> next;

        // Node constructor
        public Node(E x) {
            elem = x;
            next = null;
        }
    }

    private Node<T> first;
    private int size;


    // PriorityQueue constructor
    public LinkedPriorityQueue() {
        first = null;
        size = 0;
    }

    // Deletes all elements from queue
    public void clear() {
        first = null;
        size = 0;
    }

    // Test for emptiness
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Deletes first element in queue
    public void dequeue() {
        if (isEmpty()) {
            throw new dataStructures.PriorityQueue.EmptyPriorityQueueException();
        } else {
            first = first.next;
            size--;
        }
    }

    // Retrieves first element in queue
    public T first() {
        if (isEmpty()) {
            throw new dataStructures.PriorityQueue.EmptyPriorityQueueException();
        }
        return first.elem;
    }

    @Override
    public void enqueue(T x) {
        Node<T> aux = new Node<>(x);

        if(isEmpty()){                                  // Priority queue was empty
            first = aux;
        } else if(x.compareTo(first.elem) < 0) {        // Has higher priority
            aux.next = first;
            first    = aux;
        } else {
            Node<T> iter = first;
            Node<T> prev = null;

            // Advance while priority is less or equal
            while ((aux != null) && (x.compareTo(iter.elem) >= 0)){
                prev = iter;
                iter = iter.next;
            }

            // Insert given node in position
            aux.next = iter;
            prev.next = aux;
        }
    }

    // Returns number of elements in queue
    public int size() {
        return size;
    }

    // String representation
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        for(Node<T> node = first; node != null; node = node.next)
            s += node.elem + (node.next != null ? "," : "");
        s += ")";
        return s;
    }
}
