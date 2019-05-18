package dataStructures.dictionary;

//      ___ _      _   _
//     /   (_) ___| |_(_) ___  _ __   __ _ _ __ _   _
//    / /\ / |/ __| __| |/ _ \| '_ \ / _` | '__| | | |
//   / /_//| | (__| |_| | (_) | | | | (_| | |  | |_| |
//  /___,' |_|\___|\__|_|\___/|_| |_|\__,_|_|   \__, |
//                   Memorias de un Informático|___/

import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;
import dataStructures.tuple.Tuple2;


public class AVLDictionary<K extends Comparable<? super K>, V> implements Dictionary<K, V> {

    // Internal variable for storing the values
    private SearchTree<K, V> tree;

    // Constructor | O(1)
    public AVLDictionary() {
        tree = new AVL<>();
    }

    // True if dictionary is empty, else false
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    // Return number of elements in dictionary | O(log n)
    public int size() {
        return tree.size();
    }

    // Insert elements in dictionary | O(log n)
    public void insert(K k, V v) {
        tree.insert(k, v);
    }

    // Delete an element with key in dictionary | O(log n)
    public void delete(K k) {
        tree.delete(k);
    }

    // Return the value of an element in tree | O(log n)
    public V valueOf(K k) {
        return tree.search(k);
    }

    // O(log n)
    public boolean isDefinedAt(K k) {
        return tree.isElem(k);
    }

    // Returns iterable for keys
    public Iterable<K> keys() {
        return tree.inOrder();
    }

    // Returns iterable for values
    public Iterable<V> values() {
        return tree.values();
    }

    // Returns iterable for keys and values as a tuple
    public Iterable<Tuple2<K, V>> keysValues() {
        return tree.keysValues();
    }

    // String representation
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className + "(";
        if (!tree.isEmpty()) {
            for (Tuple2<K, V> t : tree.keysValues())
                s += t.first() + "->" + t.second() + ",";
            s = s.substring(0, s.length() - 1);
        }
        s += ")";
        return s;
    }
}
