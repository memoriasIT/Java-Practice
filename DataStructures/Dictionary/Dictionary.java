package dataStructures.dictionary;

import dataStructures.tuple.Tuple2;

//      ___ _      _   _
//     /   (_) ___| |_(_) ___  _ __   __ _ _ __ _   _
//    / /\ / |/ __| __| |/ _ \| '_ \ / _` | '__| | | |
//   / /_//| | (__| |_| | (_) | | | | (_| | |  | |_| |
//  /___,' |_|\___|\__|_|\___/|_| |_|\__,_|_|   \__, |
//                   Memorias de un Informático|___/


public interface Dictionary<K, V> {

    // Return true if dictionary is empty, else false
    boolean isEmpty();

    // Return number of elements in dictionary
    int size();

    // Inserts a new value into dictionary
    // If key already present value is replaced
    void insert(K k, V v);

    // Return the value of a key present in dictionary
    V valueOf(K k);

    // Test for a key presence in dictionary
    boolean isDefinedAt(K k);

    // Delete value from dictionary
    void delete(K k);

    // Returns iterable over all keys of the dictionary
    Iterable<K> keys();

    // Returns iterable over all value of the dictionary
    Iterable<V> values();

    // Returns iterable over all values and keys of the dictionary
    Iterable<Tuple2<K, V>> keysValues();

}
