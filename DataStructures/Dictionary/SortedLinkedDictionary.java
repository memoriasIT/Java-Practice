package dataStructures.dictionary;

import dataStructures.tuple.Tuple2;

import java.util.Iterator;
import java.util.NoSuchElementException;

//      ___ _      _   _
//     /   (_) ___| |_(_) ___  _ __   __ _ _ __ _   _
//    / /\ / |/ __| __| |/ _ \| '_ \ / _` | '__| | | |
//   / /_//| | (__| |_| | (_) | | | | (_| | |  | |_| |
//  /___,' |_|\___|\__|_|\___/|_| |_|\__,_|_|   \__, |
//                   Memorias de un Informático|___/


public class SortedLinkedDictionary<K extends Comparable<? super K>, V> implements Dictionary<K, V> {

    // Nodes for linked structure
    static private class Node<A, B> {
        A key;
        B value;
        Node<A, B> next;

        // Constructor
        Node(A k, B v, Node<A, B> node) {
            key = k;
            value = v;
            next = node;
        }
    }

    // Private variables for dictionary
    protected Node<K, V> first;
    protected int size;

    //Constructor
    public SortedLinkedDictionary() {
        first = null;
        size = 0;
    }

    // Test for emptiness
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    // Returns number of elements in dictionary
    public int size() {
        return size;
    }

    // Linear Search
    private class Finder {
        Node<K, V> previous;
        Node<K, V> current;
        boolean found;

        public Finder(K k) {
            // Initialize variables
            previous = null;
            current = first;

            // Search - Because it's sorted we can compare keys to make it more efficient
            while (current != null && current.key.compareTo(k) < 0) {
                previous = current;
                current = current.next;
            }

            // Can be greater or equal, check if equal and not null
            found = (current != null) && current.key.equals(k);
        }
    }

    // Inserts new element into dictionary
    public void insert(K k, V v) {
        Finder finder = new Finder(k);

        if (finder.found) {                         // Change value cause key found
            finder.current.value = v;
        } else {
            if (finder.previous == null) {          // Insert in first position
                first = new Node<>(k, v, first);
            } else {                                 // Insert in between
                finder.previous.next = new Node<>(k, v, finder.current);
            }
            size++;
        }
    }

    // Return the value of a key if present
    @Override
    public V valueOf(K k) {
        Finder finder = new Finder(k);

        // Return value if found, else null
        return finder.found ? finder.current.value : null;
    }

    // Test for element in dictionary
    @Override
    public boolean isDefinedAt(K k) {
        Finder finder = new Finder(k);

        return finder.found;
    }

    // Delete element with a given key
    @Override
    public void delete(K k) {
        Finder finder = new Finder(k);

        if (finder.found) {
            if (finder.previous == null) {   // It was first element
                first = first.next;
            } else {
                finder.previous.next = finder.current.next;
            }
            size--;
        }
    }

    // String representation
    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String text = className + "(";
        for (Node<K, V> p = first; p != null; p = p.next) {
            text += p.key + "->" + p.value + (p.next != null ? "," : "");
        }
        return text + ")";
    }

    // Iterator for nodes
    private class NodeIterator {
        Node<K, V> current;

        // Constructor
        public NodeIterator() {
            current = first;
        }

        // hasNext
        public boolean hasNext() {
            return current != null;
        }

        // Returns next Node and advances a place
        public Node<K, V> nextNode() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Node<K, V> node = current;
            current = current.next;
            return node;
        }
    }

    // Iterator class for keys
    private class KeyIterator extends NodeIterator implements Iterator<K> {
        @Override
        public K next() {
            return super.nextNode().key;
        }
    }

    // Iterator class for values
    private class ValueIterator extends NodeIterator implements Iterator<V> {
        @Override
        public V next() {
            return super.nextNode().value;
        }
    }

    // Iterator class for tuples of key-value
    private class KeyValueIterator extends NodeIterator implements Iterator<Tuple2<K, V>> {
        @Override
        public Tuple2<K, V> next() {
            Node<K, V> node = super.nextNode();
            return new Tuple2<>(node.key, node.value);
        }
    }

    // Returns key Iterator
    @Override
    public Iterable<K> keys() {
        return new Iterable<K>() {
            public Iterator<K> iterator() {
                return new KeyIterator();
            }
        };
    }

    // Return value iterator
    @Override
    public Iterable<V> values() {
        return new Iterable<V>() {
            public Iterator<V> iterator() {
                return new ValueIterator();
            }
        };
    }

    // Return tuple iterator
    @Override
    public Iterable<Tuple2<K, V>> keysValues() {
        return new Iterable<Tuple2<K, V>>() {
            public Iterator<Tuple2<K, V>> iterator() {
                return new KeyValueIterator();
            }
        };
    }


}

