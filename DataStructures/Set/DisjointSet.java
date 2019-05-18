package dataStructures.set;
import dataStructures.list.List;

public interface DisjointSet<T extends Comparable<? super T>> {

    // Test for emptiness
    public boolean isEmpty();

    // Test for element in set
    boolean isElem(T elem);

    // Returns number of elements in set
    int numElements();

    // Adds element to set. If not present create a new eq class, if already present pass
    void add(T elem);

    // Returns if both elements are in the same eq class
    boolean areConnected(T elem1, T elem2);

    // Returns list with elements in teh same eq class. If not present give empty list
    List<T> kind(T elem);

    // Joins two eq classes. If one not present give IllegalArgumentException
    void union(T elem1, T elem2);

    // All elements are related to the canonical number
    void flatten();

    // Give a list with all classes as lists
    List<List<T>> kinds();
}

