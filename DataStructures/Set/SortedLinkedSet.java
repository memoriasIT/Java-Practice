package dataStructures.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018


public class SortedLinkedSet<T extends Comparable<? super T>> implements Set<T> {

    // Node structure for linking elements
    static private class Node<E> {
        E elem;
        Node<E> next;

        Node(E x, Node<E> node) {
            elem = x;
            next = node;
        }
    }

    // Private variables
    private Node<T> first;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(T x) {
        Node<T> previous = null;
        Node<T> current = first;

        // Sorted, find place
        while (current != null && current.elem.compareTo(x) < 0) {
            previous = current;
            current = current.next;
        }

        // As not <0 can be greater or equal. If equal -> we found it
        boolean found = (current != null) && current.elem.equals(x);

        // Only insert if not found because it's a set
        if (!found) {
            // First position
            if (previous == null) {
                first = new Node<>(x, first);
            } else {
                previous.next = new Node<>(x, current);
            }
            size++;
        }
    }

    @Override
    public boolean isElem(T x) {
        Node<T> current = first;

        // While aux variable lower than element set variable to next node
        while (current != null && current.elem.compareTo(x) < 0) {
            current = current.next;
        }

        // Found or not
        return (current != null && current.elem.equals(x));
    }

    @Override
    public void delete(T x) {
        Node<T> previous = null;
        Node<T> current = first;

        // While lower
        while (current != null && current.elem.compareTo(x) < 0) {
            previous = current;
            current = current.next;
        }

        // Found?
        boolean found = (current != null) && current.elem.equals(x);
        if (found) {
            // First
            if (previous == null) {
                first = current.next;
            } else {
                previous.next = current.next;
            }
            size--;
        }
    }


    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String text = className + "(";
        for (Node<T> p = first; p != null; p = p.next) {
            text += p.elem + (p.next != null ? "," : "");
        }
        return text + ")";
    }

    @Override
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T x = current.elem;
            current = current.next;
            return x;
        }
    }
}
