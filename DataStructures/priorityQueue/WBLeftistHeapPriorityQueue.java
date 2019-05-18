package dataStructures.priorityQueue;
import dataStructures.heap.WBLeftistHeap;
import dataStructures.PriorityQueue.EmptyPriorityQueueException;

//     ___      _            _ _           ____
//    / _ \_ __(_) ___  _ __(_) |_ _   _  /___ \_   _  ___ _   _  ___
//   / /_)/ '__| |/ _ \| '__| | __| | | |//  / / | | |/ _ \ | | |/ _ \
//  / ___/| |  | | (_) | |  | | |_| |_| / \_/ /| |_| |  __/ |_| |  __/
//  \/    |_|  |_|\___/|_|  |_|\__|\__, \___,_\ \__,_|\___|\__,_|\___|
//  Memorias de un informático     |___/

public class WBLeftistHeapPriorityQueue<T extends Comparable<? super T>> implements dataStructures.PriorityQueue.PriorityQueue<T> {
    // Private heap
    private WBLeftistHeap<T> heap;

    // Constructor
    public WBLeftistHeapPriorityQueue(){
        heap = new WBLeftistHeap<>();
    }

    // Test for emptiness
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Add element in queue
    @Override
    public void enqueue(T x) {
        heap.insert(x);
    }

    // Returns first element
    @Override
    public T first() {
        if(isEmpty()){
            throw new EmptyPriorityQueueException("First on emtpy queue");
        } else {
            return heap.minElem();
        }
    }

    // Deletes minimum element if possible
    @Override
    public void dequeue() {
        if (heap.isEmpty()) {
            throw new EmptyPriorityQueueException("Can't dequeue en empty queue");
        } else {
            heap.delMin();
        }
    }

    // String representation
    @Override
    public String toString() {
        WBLeftistHeap<T> clonedHeap = new WBLeftistHeap<>(heap);
        String className = getClass().getSimpleName();
        String s = className+"(";
        boolean stop = clonedHeap.isEmpty();
        while(!stop) {
            s += clonedHeap.minElem();
            clonedHeap.delMin();
            stop = clonedHeap.isEmpty();
            if(!stop)
                s += ",";
        }
        s += ")";
        return s;
    }
}
