package dataStructures.heap;


//   /\  /\___  __ _ _ __
//  / /_/ / _ \/ _` | '_ \
// / __  /  __/ (_| | |_) |
// \/ /_/ \___|\__,_| .__/
// MemoriasIT - 2019|_|


public interface Heap<T extends Comparable<? super T>> {
    // Test for emptiness
    boolean isEmpty();

    // Returns number of elements in heap
    int size();

    // Insert new element in heap
    void insert(T x);

    // Returns minimum element
    T minElem();

    // Deletes minimum element
    void delMin();

}
