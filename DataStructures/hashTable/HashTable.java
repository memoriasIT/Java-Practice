package dataStructures.hashTable;

import dataStructures.tuple.Tuple2;

// MemoriasIT -2019   _    _____      _     _
//     /\  /\__ _ ___| |__/__   \__ _| |__ | | ___
//    / /_/ / _` / __| '_ \ / /\/ _` | '_ \| |/ _ \
//   / __  / (_| \__ \ | | / / | (_| | |_) | |  __/
//   \/ /_/ \__,_|___/_| |_\/   \__,_|_.__/|_|\___|

public interface HashTable<K, V> {
    // Tests for emptiness
    boolean isEmpty();

    // Returns number of elements in table
    int size();

    // Inserts a key in HashTable, if already present value is changed
    void insert(K k, V v);

    // Searches element by key
    V search(K k);

    // Tests if an element is present by key
    boolean isElem(K k);

    // Deletes an element given a certain key
    void delete(K k);

    // Retrieves iterable for keys
    Iterable<K> keys();

    // Retrieves iterable for values
    Iterable<V> values();

    // Retrieves iterable for key-value tuple
    Iterable<Tuple2<K, V>> keysValues();
}
