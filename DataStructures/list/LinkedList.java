package dataStructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

//      __ _     _
//     / /(_)___| |_
//    / / | / __| __|
//   / /__| \__ \ |_
//   \____/_|___/\__|
//  MemoriasIT - 2018

public class LinkedList<T> implements List<T> {

    // Nodes for Linked Structure
    private static class Node<E> {
        private E elem;
        private Node<E> next;

        public Node(E x, Node<E> node) {
            elem = x;
            next = node;
        }
    }

    // Private variables
    private Node<T> first, last;
    private int size;

    // Constructor
    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    // Private Methods
    private void validateIndex(int i) {
        if (i < 0 || i >= size()) {
            throw new ListException("Index not valid " + i);
        }
    }

    // Linear implementation to get node at index i
    private Node<T> atIndex(int i) {
        Node<T> aux = first;

        for (int pos = 0; pos < i; pos++) {
            aux = aux.next;
        }
        return aux;
    }

    // True if List is empty, else false
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns number of elements in list
    @Override
    public int size() {
        return size;
    }

    // Get element at index i
    @Override
    public T get(int i) {
        validateIndex(i);
        return atIndex(i).elem;
    }

    // Change element
    @Override
    public void set(int i, T x) {
        validateIndex(i);
        atIndex(i).elem = x;

    }

    // Insert new element
    @Override
    public void insert(int i, T x) {
        if (i == size) {                // Insert in last element
            Node<T> aux = new Node<>(x, null);
            // Empty list
            if (size == 0) {
                first = aux;
            } else {
                last.next = aux;
            }
            last = aux;
        } else if (i == 0) {              // Insertion at head with list not empty
            first = new Node<>(x, first);
        } else {                        // Internal Insertion
            validateIndex(i);
            Node<T> prev = atIndex(i - 1);
            prev.next = new Node<>(x, prev.next);
        }
        size++;
    }

    @Override
    public void append(T x) {
        Node<T> node = new Node<>(x, null);
        if (size == 0) {         // Empty list
            first = node;
        } else {
            last.next = node;
        }
        last = node;
        size++;
    }

    @Override
    public void prepend(T x) {
        first = new Node<>(x, first);
        if (size == 0) {
            last = first;
        }
        size++;
    }

    @Override
    public void remove(int i) {
        validateIndex(i);
        if (size == 0) {         // First element
            first = first.next;
            if (last == null) {  // Was last element
                last = null;
            }

        } else {
            Node<T> prev = atIndex(i - 1);
            prev.next = prev.next.next;

            if (i == (size - 1)) { // Last element
                last = prev;
            }
        }
        size--;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        Node<T> current;

        public LinkedListIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            T x = current.elem;
            current = current.next;
            return x;
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
