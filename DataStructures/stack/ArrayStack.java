package dataStructures.stack;

import java.util.Arrays;

//    __ _             _
//   / _\ |_ __ _  ___| | __
//   \ \| __/ _` |/ __| |/ /
//   _\ \ || (_| | (__|   <
//   \__/\__\__,_|\___|_|\_\
//   MemoriasIT - 2018

public class ArrayStack<T> implements Stack<T> {
    protected T[] elements;
    protected int nextFree;

    private static final int INITIAL_CAPACITY = 128;

    // Generate empty stack with capacity = n; O(1)
    public ArrayStack(int n) {
        elements = (T[]) new Object[n];
        nextFree = 0;
    }

    // Generate stack with INITIAL_CAPACITY; O(1)
    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }


    // True if empty, else false
    @Override
    public boolean isEmpty() {
        return nextFree == 0;
    }

    // Make sure contents doesn't overflow
    private void ensureCapacity() {
        if (nextFree == elements.length) {
            elements = Arrays.copyOf(elements, 2 * elements.length);
        }
    }

    // Add element to Array
    @Override
    public void push(T x) {
        ensureCapacity();
        elements[nextFree] = x;
        nextFree++;
    }

    // Return last element of the stack
    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't top on empty Stack");
        }
        return elements[nextFree - 1];

    }


    // Delete last element of array
    @Override
    public void pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Empty Stack");
        }
        nextFree--;
    }

    // String representation
    // ArrayStack(last, last-1, ...)
    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String s = className + "(";

        for (int i = nextFree - 1; i >= 0; i--) {
            s += elements[i] + (i > 0 ? "," : "");
        }
        s += ")";

        return s;
    }

}
