package dataStructures.queue;

import java.util.LinkedList;
import java.util.Iterator;

//     ____
//    /___ \_   _  ___ _   _  ___
//   //  / / | | |/ _ \ | | |/ _ \
//  / \_/ /| |_| |  __/ |_| |  __/
//  \___,_\ \__,_|\___|\__,_|\___|
// Memorias de un informático - 2018

public class LinkedListQueue<T> implements Queue<T> {
    protected LinkedList<T> elements;

    // Constructor
    public LinkedListQueue() {
        elements = new LinkedList<>();
    }

    // Add element to last position
    public void enqueue(T x) {
        elements.addLast(x);
    }

    // True if empty, else false
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Gets first element in queue
    public T first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Can't first on empty queue");
        }
        return elements.getFirst();
    }

    // Removes first element from queue
    public void dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Can't dequeue on empty queue");
        }

        elements.removeFirst();
    }

    // String representation
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
