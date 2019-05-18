package dataStructures.set;

import java.util.Iterator;

import dataStructures.hashTable.HashPrimes;
import dataStructures.hashTable.HashTable;
import dataStructures.hashTable.SeparateChainingHashTable;

//   __      _
//  / _\ ___| |_
//  \ \ / _ \ __|
//  _\ \  __/ |_
//  \__/\___|\__|
// MemoriasIT - 2018

public class HashSet<T> implements Set<T> {

    // Private Hash structure for implementing set
    private static class Nothing{};
    private Nothing nothing = new Nothing();

    private HashTable<T, Nothing> hashT;

    // Constructor (Separate chaining hash table with prime greater than 100 load factor 5
    public HashSet(){
        hashT = new SeparateChainingHashTable<>(HashPrimes.primeGreaterThan(100), 5);
    }

    // Delete element in set
    public void delete(T elem) {
        hashT.delete(elem);
    }

    // Insert element in set
    public void insert(T elem) {
        hashT.insert(elem, nothing);
    }

    // Test for element in set
    public boolean isElem(T elem){
        return hashT.isElem(elem);
    }

    // Test for emptiness
    public boolean isEmpty(){
        return hashT.isEmpty();
    }


    // Return number of elements in set
    public int size() {
        return hashT.size();
    }

    // Iterator for keys
    public Iterator<T> iterator(){
        return hashT.keys().iterator();
    }

    // String representation
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        Iterator<T> it = this.iterator();
        while(it.hasNext())
            s += it.next() + (it.hasNext() ? "," : "");
        s += ")";
        return s;
    }




}
