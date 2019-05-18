package dataStructures.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

//      __ _     _
//     / /(_)___| |_
//    / / | / __| __|
//   / /__| \__ \ |_
//   \____/_|___/\__|
//  MemoriasIT - 2018


public class ArrayList<T> implements List<T> {

    // Private variables
    protected T[] elements;
    protected int size;
    private static final int INITIAL_CAPACITY = 128;


    // Constructor
    public ArrayList(int n) {
        elements = (T[]) new Object[n];
        size = 0;
    }

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    // Private methods
    // Prevent IndexOutOfBounds
    private void validateIndex(int i) {
        if (i < 0 || i >= size) {
            throw new ListException("Invalid position" + i);
        }
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
    }

    // True if empty, else false
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // Returns size of list
    @Override
    public int size() {
        return size;
    }


    // Get element in index i, can cause ListException
    @Override
    public T get(int i) {
        validateIndex(i);
        return elements[i];
    }

    // Set element by index, can cause ListException
    @Override
    public void set(int i, T x) {
        validateIndex(i);
        elements[i] = x;
    }

    // Add new element at index i
    @Override
    public void insert(int i, T x) {
        ensureCapacity();
        if (i != size) {
            validateIndex(i);
            for (int pos = size; pos > i; pos--) {
                elements[pos] = elements[pos - 1];
            }
        }
        elements[i] = x;
        size++;
    }

    // Add element at the end of the list
    @Override
    public void append(T x) {
        ensureCapacity();
        elements[size] = x;
        size++;
    }

    // Add element at the beginning of the list
    @Override
    public void prepend(T x) {
        ensureCapacity();
        for (int pos = size; pos > 0; pos--)
            elements[pos] = elements[pos - 1];
        elements[0] = x;
        size++;
    }

    // Remove element at index i
    @Override
    public void remove(int i) {
        validateIndex(i);
        for (int pos = i; pos < size - 1; pos++) {
            elements[pos] = elements[pos + 1];
        }
        size--;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        int current;

        public ArrayListIterator() {
            current = 0;
        }

        public boolean hasNext() {
            return current < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T x = elements[current];
            current++;
            return x;
        }
    }

    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String s = className + "(";
        for (int i = 0; i < size; i++)
            s += elements[i] + (i < size - 1 ? "," : "");
        s += ")";
        return s;
    }
}
