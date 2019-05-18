package dataStructures.queue;


public interface DoubleEndedQueue<T> {
    // Test for emptiness
    boolean isEmpty();

    // Adds element at first place
    void addFirst(T x);

    // Adds element at last place
    void addLast(T x);

    // Returns first element
    T first();

    // Returns last element
    T last();

    // Deletes first element
    void deleteFirst();

    // Deletes last element
    void deleteLast();
}

