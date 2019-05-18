package dataStructures.queue;

//     ____
//    /___ \_   _  ___ _   _  ___
//   //  / / | | |/ _ \ | | |/ _ \
//  / \_/ /| |_| |  __/ |_| |  __/
//  \___,_\ \__,_|\___|\__,_|\___|
// Memorias de un informático - 2018

public class LinkedQueue<T> implements Queue<T> {

    // Nodes for a linked structure
    private static class Node<E> {
        private E elem;
        private Node<E> next;

        public Node(E x, Node<E> node) {
            elem = x;
            next = node;
        }
    }

    // queue private variables
    Node<T> first, last;

    // Constructor. O(1)
    public LinkedQueue() {
        first = null;
        last = null;
    }

    // True if empty, else false. O(1)
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    // O(1)
    @Override
    public void enqueue(T x) {
        Node<T> aux = new Node<T>(x, null);

        // If empty set first element
        if (isEmpty()) {
            first = aux;
            last = aux;
        } else { // Set last in last element
            last.next = aux;
            last = last.next;
        }
    }

    // O(1)
    @Override
    public T first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Can't get first element on emtpy queue");
        }
        return first.elem;
    }

    // 0(1)
    @Override
    public void dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Can't dequeue on empty queue");
        }
        first = first.next;
        if (first == null) {
            last = null;
        }
    }

    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String s = className + "(";
        for (Node<T> node = first; node != null; node = node.next)
            s += node.elem + (node.next != null ? "," : "");
        s += ")";
        return s;
    }
}
