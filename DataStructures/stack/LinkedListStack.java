package dataStructures.stack;

import java.util.Iterator;
import java.util.LinkedList;

//    __ _             _
//   / _\ |_ __ _  ___| | __
//   \ \| __/ _` |/ __| |/ /
//   _\ \ || (_| | (__|   <
//   \__/\__\__,_|\___|_|\_\
//   MemoriasIT - 2018

public class LinkedListStack<T> implements Stack<T> {
    protected LinkedList<T> elements;

    // Empty stack. O(1)
    public LinkedListStack() {
        elements = new LinkedList<>();
    }

    // Stack with element
    public void push(T elem) {
        elements.addFirst(elem);
    }

    // True if is empty, else false
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Return last inserted element. Throws EmptyStackException
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't top on empty stack");
        }
        return elements.getFirst();
    }

    // Remove last inserted element. Throws EmptyStackException
    public void pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Can't pop on empty stack");
        }
        elements.removeFirst();
    }

    @Override
    public String toString() {
        String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);
        String text = className + "(";
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            text += it.next() + (it.hasNext() ? "," : "");
        }
        return text + ")";
    }

}
