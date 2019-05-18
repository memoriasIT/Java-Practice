//      ___ _      _   _
//     /   (_) ___| |_(_) ___  _ __   __ _ _ __ _   _
//    / /\ / |/ __| __| |/ _ \| '_ \ / _` | '__| | | |
//   / /_//| | (__| |_| | (_) | | | | (_| | |  | |_| |
//  /___,' |_|\___|\__|_|\___/|_| |_|\__,_|_|   \__, |
//                   Memorias de un Informático|___/

package dataStructures.dictionary;

import dataStructures.hashTable.HashPrimes;
import dataStructures.hashTable.HashTable;
import dataStructures.hashTable.SeparateChainingHashTable;
import dataStructures.tuple.Tuple2;

public class HashDictionary<K,V> implements Dictionary<K,V> {

    // Internal hash structure
    private HashTable<K,V> hashT;

    // Constructor
    public HashDictionary() {
        hashT = new SeparateChainingHashTable<>(HashPrimes.primeGreaterThan(100),5);
    }

    // Insert element
    public void insert(K k, V v) {
        hashT.insert(k, v);
    }

    // Delete element
    public void delete(K k) {
        hashT.delete(k);
    }

    // Test for emptiness
    public boolean isEmpty() {
        return hashT.isEmpty();
    }

    // Returns number of elements
    public int size() {
        return hashT.size();
    }

    // Search for element by key
    public V valueOf(K k) {
        return hashT.search(k);
    }

    // Test for element by key
    public boolean isDefinedAt(K k) {
        return hashT.isElem(k);
    }

    // Returns iterable for keys in dictionary
    public Iterable<K> keys() {
        return hashT.keys();
    }

    // Returns iterable for values in dictionary
    public Iterable<V> values() {
        return hashT.values();
    }

    // Returns tuples with keys and values
    public Iterable<Tuple2<K,V>> keysValues() {
        return hashT.keysValues();
    }

    // String representation of dictionary
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        if(!hashT.isEmpty()) {
            for(Tuple2<K,V> t : hashT.keysValues())
                s += t.first()+"->"+t.second()+",";
            s = s.substring(0, s.length()-1);
        }
        s += ")";
        return s;
    }

}

