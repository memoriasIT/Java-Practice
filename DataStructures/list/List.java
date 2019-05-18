package dataStructures.list;

//      __ _     _
//     / /(_)___| |_
//    / / | / __| __|
//   / /__| \__ \ |_
//   \____/_|___/\__|
//  MemoriasIT - 2018

public interface List<T> extends Iterable<T> {
    // True if empty, else false
    boolean isEmpty();

    // Return number of elements in list
    int size();

    // Retrieves an element from the list by index
    T get(int i);

    // Modifies an element with an index, does not insert a new element
    void set(int i, T x);

    // Insert new element in list, old element at index i and successors get increased
    void insert(int i, T x);

    // Add element at the end of list
    void append(T x);

    // Inserts element at the head of list
    void prepend(T x);

    // Removes element with index
    void remove(int i);

}
