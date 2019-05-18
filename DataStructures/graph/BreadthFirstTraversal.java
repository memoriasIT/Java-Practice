package dataStructures.graph;

import dataStructures.queue.ArrayQueue;

public class BreadthFirstTraversal<V> extends Traversal<V> {

    // Constructor
    public BreadthFirstTraversal(Traversable<V> g, V source) {
        super(g,source);
    }

    // Store with fifo style
    private class FIFOStore<T> extends ArrayQueue<T> implements Store<T> {

        public void insert(T elem) { enqueue(elem); }

        public T extract() { T elem = first(); dequeue(); return elem; }

    }

    // Store edge
    public Store<DiEdge<V>> newStore() {
        return new FIFOStore<DiEdge<V>>();
    }

}

