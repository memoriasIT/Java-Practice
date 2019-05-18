package dataStructures.hashTable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import dataStructures.tuple.Tuple2;

// MemoriasIT -2019   _    _____      _     _
//     /\  /\__ _ ___| |__/__   \__ _| |__ | | ___
//    / /_/ / _` / __| '_ \ / /\/ _` | '_ \| |/ _ \
//   / __  / (_| \__ \ | | / / | (_| | |_) | |  __/
//   \/ /_/ \__,_|___/_| |_\/   \__,_|_.__/|_|\___|

public class LinearProbingHashTable<K,V> implements HashTable<K, V> {

    // Private internal variables
    private K keys[];
    private V values[];
    private int size;
    private double maxLoadFactor;


    // Create empty hash table
    public LinearProbingHashTable(int numCells, double loadFactor){
        keys = (K[]) new Object[numCells];
        values = (V[]) new Object[numCells];
        size = 0;
        maxLoadFactor = loadFactor;
    }

    // Test for emptiness
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns number of elements in hashTable
    public int size(){
        return size;
    }

    // Returns array index for key
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % keys.length;
    }

    // Returns load factor
    private double loadFactor(){
        return (double) size / (double) keys.length;
    }

    // Returns insertion postion by key of association
    private int searchIdx(K key) {
        int idx = hash(key);
        while(keys[idx] != null && !keys[idx].equals(key)){
            idx = (idx + 1) % keys.length;
        }
        return idx;
    }

    // Returns value associated with key (null if not found)
    public V search(K key) {
        return values[searchIdx(key)];
    }

    // Test for element by key
    public boolean isElem(K key) {
        return keys[searchIdx(key)] != null;
    }

    // Inserts new element in table (or replaces value if already present)
    public void insert(K key, V value) {
        if(loadFactor() > maxLoadFactor)
            rehashing();
        int idx = searchIdx(key);
        if (keys[idx] == null) {
            keys[idx] = key;
            values[idx] = value;
            this.size++;
        } else if (keys[idx] != null && keys[idx].equals(key)){
            values[idx] = value;
        }
    }

    // If association found, then removed, else table not modified
    public void delete(K key) {
        int idx = searchIdx(key);
        if(keys[idx] != null){
            size--;
            keys[idx] = null;
            values[idx] = null;
            idx = (idx + 1) % keys.length;
            while(keys[idx] != null){
                size--;
                K temp1 = keys[idx]; V temp2 = values[idx];
                keys[idx] = null; values[idx] = null;
                insert(temp1, temp2);
                idx = (idx + 1) % keys.length;
            }
        }
    }



    // Double table capacity and rehash elements
    @SuppressWarnings("unchecked")
    private void rehashing() {
        // compute new table size
        int newCapacity = HashPrimes.primeDoubleThan(keys.length);
        //System.out.printf("REHASH %d\n",newCapacity);
        K oldKeys[] = keys;
        V oldValues[] = values;

        keys = (K[]) new Object[newCapacity];
        values = (V[]) new Object[newCapacity];

        // reinsert elements in new table
        for(int i=0; i<oldKeys.length; i++)
            if(oldKeys[i] != null) {
                int newIdx = searchIdx(oldKeys[i]);
                keys[newIdx] = oldKeys[i];
                values[newIdx] = oldValues[i];
            }
    }


    // Almost an iterator
    private class TableIter {
        private int visited; // number of elements already visited by this iterator
        protected int nextIdx; // index of next element to be visited by this iterator

        public TableIter() {
            visited = 0;
            nextIdx = -1; // so that after first increment it becomes 0
        }

        public boolean hasNext() {
            return visited < size;
        }

        // advance nextIdx to be index of next to be visited element
        public void advance() {
            do {
                nextIdx++;
            } while(keys[nextIdx] == null && (visited<size));
            visited++;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class KeysIter extends TableIter implements Iterator<K> {
        public K next() {
            advance();
            return keys[nextIdx];
        }
    }

    private class ValuesIter extends TableIter implements Iterator<V> {
        public V next() {
            advance();
            return values[nextIdx];
        }
    }

    private class KeysValuesIter extends TableIter implements Iterator<Tuple2<K,V>> {
        public Tuple2<K,V> next() {
            advance();
            return new Tuple2<K,V>(keys[nextIdx],values[nextIdx]);
        }
    }

    public Iterable<K> keys() {
        return new Iterable<K>(){
            public Iterator<K> iterator() {
                return new KeysIter();
            }
        };
    }

    public Iterable<V> values() {
        return new Iterable<V>(){
            public Iterator<V> iterator() {
                return new ValuesIter();
            }
        };
    }

    public Iterable<Tuple2<K,V>> keysValues() {
        return new Iterable<Tuple2<K,V>>(){
            public Iterator<Tuple2<K,V>> iterator() {
                return new KeysValuesIter();
            }
        };
    }

    // String representation for hashtable
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length()+1);
        String s = className+"(";
        if(!isEmpty()) {
            for(Tuple2<K,V> t : keysValues())
                s += t.first()+"->"+t.second()+",";
            s = s.substring(0, s.length()-1);
        }
        s += ")";
        return s;
    }

}
