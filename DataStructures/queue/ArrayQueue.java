package dataStructures.queue;

//     ____
//    /___ \_   _  ___ _   _  ___
//   //  / / | | |/ _ \ | | |/ _ \
//  / \_/ /| |_| |  __/ |_| |  __/
//  \___,_\ \__,_|\___|\__,_|\___|
// Memorias de un informático - 2018

public class ArrayQueue<T> implements Queue<T> {

    // Private variables
    protected T[] elements;
    protected int first, last, size;
    private static final int INITIAL_CAPACITY = 128;

    // Constructor with custom capacity
    public ArrayQueue(int n) {
        elements = (T[]) new Object[n];
        size = 0;
        first = 0;
        last = n - 1;
    }

    // Derive constructor with default capacity
    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    // Get next index with circular increment
    private int circular_increment(int i) {
        return (i + 1) % elements.length;
    }

    // Avoid overflows
    private void ensureCapacity() {
        if (size == elements.length) {
            T[] aux = (T[]) new Object[2 * elements.length];
            for (int i = 0; i < size; i++) {
                aux[i] = elements[first];
                first = circular_increment(first);
            }
            elements = aux;
            first = 0;
            last = size - 1;
        }
    }

    // True if empty, else false
    public boolean isEmpty() {
        return size == 0;
    }

    // Add new element to next available index
    public void enqueue(T x) {
        ensureCapacity();
        last = circular_increment(last);
        elements[last] = x;
        size++;
    }

    // Get first element from array
    public T first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Can't first on empty queue");
        }

        return elements[first];
    }

    // Delete first element from queue
    public void dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Can't dequeue on empty queue");
        }

        first = circular_increment(first);
        size--;
    }

    // String representation
    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String s = className + "(";
        int f = first;
        for (int i = 0; i < size; i++) {
            s += elements[f] + (i < size - 1 ? "," : "");
            f = circular_increment(f);
        }
        s += ")";
        return s;
    }
}
